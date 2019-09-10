package com.example.submission2.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.submission2.Main.MainAdapter
import com.example.submission2.Main.MainPresenter
import com.example.submission2.Main.MainView
import com.example.submission2.R
import com.example.submission2.activity.detail.DetailMatchAct
import com.example.submission2.api.ApiRepository
import com.example.submission2.model.Match
import com.example.submission2.ui.SearchActUI
import com.google.gson.Gson
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity(), MainView {

    private var matches : MutableList<Match> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    private var keyword : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchActUI().setContentView(this)

        val intent = intent
        keyword = intent.getStringExtra("keyword")

        val rvMatch = find<RecyclerView>(R.id.rv_match_league)
        rvMatch.layoutManager = LinearLayoutManager(applicationContext)
        adapter = MainAdapter(matches){
            startActivity<DetailMatchAct>(
                "idEvent" to "${it.eventId}",
                "homeTeam" to it.homeTeam,
                "awayTeam" to it.awayTeam

            )
        }

        rvMatch.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request, gson)
        presenter.getSearchTeam(keyword)

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMatchList(data: List<Match>) {

        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()

    }
}
