package com.example.submission2.Main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.submission2.R
import com.example.submission2.model.Match
import com.example.submission2.ui.ItemListUI
import org.jetbrains.anko.AnkoContext

class MainAdapter (private val matches: List<Match>, private val listener:(Match) ->Unit)
    : RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(ItemListUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(matches[position],listener)
    }

}
class TeamViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private  val homeTeamName : TextView = view.findViewById(R.id.tv_club_home_name)
    private val awayTeamName : TextView = view.findViewById(R.id.tv_club_away_name)
    private val scoreHome : TextView = view.findViewById(R.id.tv_score_home)
    private val scoreAway : TextView = view.findViewById(R.id.tv_score_away)
    private val matchDate : TextView = view.findViewById(R.id.tv_match_date)

    fun bindItem (matches : Match,listener: (Match) -> Unit){
        homeTeamName.text = matches.homeTeam
        awayTeamName.text = matches.awayTeam
        scoreHome.text = matches.homeScore.toString()
        scoreAway.text = matches.awayScore.toString()
        matchDate.text = matches.dateEvent.toString()

        if (matches.homeScore == null || matches.awayScore == null){
            scoreHome.text = null
            scoreAway.text = null

        }

        itemView.setOnClickListener {
            listener(matches)
        }

    }

}