package com.example.submission2


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.submission2.activity.detail.DetailMatchAct
import com.example.submission2.helper.database
import com.example.submission2.ui.FavoriteFragmentUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import java.nio.file.Files.delete


class FavoriteFragment : Fragment() {

    private var favorites : MutableList<Favorite> = mutableListOf()
    private lateinit var adapter: FavoriteAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FavoriteFragmentUI().createView(AnkoContext.create(requireContext(),this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefresh = find(R.id.swiperefresh)


        val rvMatch = find<RecyclerView>(R.id.rv_match_league)
        rvMatch.layoutManager = LinearLayoutManager(activity)
        adapter = FavoriteAdapter(favorites){
            context?.startActivity<DetailMatchAct>(
                "idEvent" to it.matchId,
                "homeTeam" to it.teamHomeName,
                "awayTeam" to it.teamAwayName)
            val toast = Toast.makeText(activity,it.teamHomeName + " vs " + it.teamAwayName, Toast.LENGTH_SHORT)
            toast.show()
        }

        rvMatch.adapter = adapter
        swipeRefresh.onRefresh {
            showFavorite()
        }

    }

    override fun onResume(){
        super.onResume()
        showFavorite()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            swipeRefresh.isRefreshing = false
            val result = select (Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }


}
