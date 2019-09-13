package com.example.submission2.activity.detail

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.submission2.Favorite
import com.example.submission2.R
import com.example.submission2.api.ApiRepository
import com.example.submission2.helper.database
import com.example.submission2.model.Match
import com.example.submission2.ui.DetailActivityUI
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import java.nio.file.Files

class DetailMatchAct : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter
    private lateinit var progressBar :ProgressBar
    private lateinit var item : Match
    private lateinit var swipeRefresh: SwipeRefreshLayout


    private var homeTeam :String = ""
    private var homeScore :String = ""
    private var idEvent : String = ""

    private var menuItem : Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)

        swipeRefresh = findViewById(R.id.swiperefresh)
        item = Match()

        val intent = intent
        idEvent = intent.getStringExtra("idEvent")
        homeTeam = intent.getStringExtra("homeTeam")
        homeScore = intent.getStringExtra("awayTeam")

        favoriteState()
        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailPresenter(this, request, gson)
        presenter.getDetailEvent(idEvent)
        presenter.getHomeTeamBadge(homeTeam)
        presenter.getAwayTeamBadge(homeScore)

        supportActionBar?.title = "Team Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (isFavorite) removeFromFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setFavorite()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite(){
        try {
            database.use {
                insert(Favorite.TABLE_FAVORITE,
                    Favorite.MATCH_ID to item.eventId,
                    Favorite.TEAM_HOME_NAME to item.homeTeam,
                    Favorite.TEAM_HOME_SCORE to item.homeScore,
                    Favorite.TEAM_AWAY_NAME to item.awayTeam,
                    Favorite.TEAM_AWAY_SCORE to item.awayScore,
                    Favorite.DATE_MATCH to item.dateEvent)
            }
            swipeRefresh.snackbar("Added to favorite").show()
        }catch (e: SQLiteConstraintException){
            swipeRefresh.snackbar(e.localizedMessage).show()
        }
    }

    private fun removeFromFavorite(){
        try{
            database.use{
                delete(Favorite.TABLE_FAVORITE, "(MATCH_ID ={idEvent})",
                    "idEvent" to idEvent)
            }
            swipeRefresh.snackbar("Removed to favorite").show()
        }catch (e:SQLiteConstraintException){
            swipeRefresh.snackbar(e.localizedMessage).show()
        }

    }

    //mengatur icon favorite
    private fun setFavorite(){
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    private fun favoriteState(){
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs("(MATCH_ID = {idEvent})",
                    "idEvent" to idEvent)
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun showLoading() {
       // progressBar.visible()
    }

    override fun hideLoading() {
        //progressBar.invisible()
    }

    override fun showMatchList(data: List<Match>) {
        swipeRefresh.isRefreshing = false
        item = Match(
            data[0].eventId,
            data[0].homeTeam,
            data[0].awayTeam,
            data[0].homeScore,
            data[0].awayScore,
            data[0].dateEvent,
            data[0].nameLeague,
            data[0].homeFormation,
            data[0].homeGoal,
            data[0].awayFormation,
            data[0].awayGoal

        )
        //swipeRefresh.isRefreshing = false
        val scoreHome = findViewById<TextView>(R.id.tv_score_home)
        scoreHome.text = data[0].homeScore.toString()

        val formationHome = findViewById<TextView>(R.id.tv_home_formation)
        formationHome.text = data[0].homeFormation.toString()

        val clubHome = findViewById<TextView>(R.id.tv_club_home_name)
        clubHome.text = data[0].homeTeam

        val goalHome = findViewById<TextView>(R.id.tv_home_Goal)
        goalHome.text = """${data[0].homeGoal}"""

        val scoreAway = findViewById<TextView>(R.id.tv_score_away)
        scoreAway.text = data[0].awayScore.toString()

        val clubAway = findViewById<TextView>(R.id.tv_club_away_name)
        clubAway.text = data[0].awayTeam

        val dateMatch = findViewById<TextView>(R.id.tv_match_date)
        dateMatch.text = data[0].dateEvent

        val formationAway = findViewById<TextView>(R.id.tv_away_formation)
        formationAway.text = data[0].awayFormation.toString()

        val goalAway = findViewById<TextView>(R.id.tv_away_goal)
        goalAway.text = """${data[0].awayGoal}""".trimMargin()

    }

    override fun showHomeBadge(data: List<Match>) {
        item = Match( data[0].teamBadge )

        val homeTeam = findViewById<ImageView>(R.id.iv_club_home)
        Picasso.get().load(data[0].teamBadge).into(homeTeam)

    }

    override fun showAwayBadge(data: List<Match>) {
        item = Match( data[0].teamBadge )

        val awayTeam = findViewById<ImageView>(R.id.iv_club_away)
        Picasso.get().load(data[0].teamBadge).into(awayTeam)
    }

}
