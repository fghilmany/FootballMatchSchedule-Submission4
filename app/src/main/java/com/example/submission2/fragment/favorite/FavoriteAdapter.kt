package com.example.submission2.fragment.favorite

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.submission2.R
import com.example.submission2.ui.ItemListUI
import org.jetbrains.anko.AnkoContext

class FavoriteAdapter (private val favorite: List<Favorite>, private val listener:(Favorite)->Unit)
    :RecyclerView.Adapter<FavoriteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemListUI().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)
    }

}

class FavoriteViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private  val homeTeamName : TextView = view.findViewById(R.id.tv_club_home_name)
    private val awayTeamName : TextView = view.findViewById(R.id.tv_club_away_name)
    private val scoreHome : TextView = view.findViewById(R.id.tv_score_home)
    private val scoreAway : TextView = view.findViewById(R.id.tv_score_away)
    private val matchDate : TextView = view.findViewById(R.id.tv_match_date)

    fun bindItem (favorite : Favorite, listener: (Favorite) -> Unit){
        homeTeamName.text = favorite.teamHomeName
        awayTeamName.text = favorite.teamAwayName
        scoreHome.text = favorite.teamHomeScore
        scoreAway.text = favorite.teamAwayScore
        matchDate.text = favorite.dateMatch

        itemView.setOnClickListener {
            listener(favorite)
        }

    }

}
