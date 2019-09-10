package com.example.submission2.activity.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.submission2.R
import com.example.submission2.api.ApiRepository
import com.example.submission2.model.Match
import com.example.submission2.ui.DetailActivityUI
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.setContentView

class DetailMatchAct : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter
    private lateinit var progressBar :ProgressBar
    private lateinit var item : Match


    private var homeClub :String = ""
    private var awayClub :String = ""
    private var idEvent : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)


        val intent = intent
        idEvent = intent.getStringExtra("idEvent")
        homeClub = intent.getStringExtra("homeTeam")
        awayClub = intent.getStringExtra("awayTeam")

        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailPresenter(this, request, gson)
        presenter.getDetailEvent(idEvent)
        presenter.getHomeTeamBadge(homeClub)
        presenter.getAwayTeamBadge(awayClub)
    }

    override fun showLoading() {
       // progressBar.visible()
    }

    override fun hideLoading() {
        //progressBar.invisible()
    }

    override fun showMatchList(data: List<Match>) {
        item = Match(
            data[0].homeGoal,
            data[0].awayTeam,
            data[0].homeTeam,
            data[0].awayScore,
            data[0].homeScore,
            data[0].dateEvent,
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
