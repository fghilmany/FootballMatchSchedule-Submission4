package com.example.submission2.activity.detail

import com.example.submission2.api.ApiRepository
import com.example.submission2.api.TheSportDBApi
import com.example.submission2.model.MatchResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter (
    private val view: DetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson){

    fun getHomeTeamBadge(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamBadge(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showHomeBadge(data.teams)
            }
        }

    }

    fun getAwayTeamBadge(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamBadge(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showAwayBadge(data.teams)
            }
        }

    }

    fun getDetailEvent(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailEvent(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showMatchList(data.events)
            }
        }
    }

}