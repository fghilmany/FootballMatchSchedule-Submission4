package com.example.submission2.Main

import com.example.submission2.api.ApiRepository
import com.example.submission2.api.TheSportDBApi
import com.example.submission2.model.MatchResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (
    private val view: MainView ,
    private val apiRepository: ApiRepository,
    private val gson: Gson){

    fun getPrevMatch(league:String?){
        view.showLoading()
        doAsync{
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPrevMatch(league)),
                MatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showMatchList(data.events)
            }

        }
    }

    fun getNextMatch(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showMatchList(data.events)
            }
        }
    }

    fun getDetailLeague(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeagueDetail(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showMatchList(data.leagues)
            }
        }
    }

    fun getSearchTeam(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchTeam(league)),
                MatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showMatchList(data.event)
            }
        }

    }



}
