package com.example.submission2.activity.detail

import android.util.Log
import com.example.submission2.api.ApiRepository
import com.example.submission2.api.TheSportDBApi
import com.example.submission2.model.MatchResponse
import com.example.submission2.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter (
    private val view: DetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
){

    fun getHomeTeamBadge(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data =
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportDBApi.getTeamBadge(league)).await(),
                    MatchResponse::class.java
                )


            view.showMatchList(data.teams)
            view.hideLoading()
        }

    }

    fun getAwayTeamBadge(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data =
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportDBApi.getTeamBadge(league)).await(),
                    MatchResponse::class.java
                )


            view.showMatchList(data.teams)
            view.hideLoading()
        }

    }

    fun getDetailEvent(league: String?){
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data =
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportDBApi.getDetailEvent(league)).await(),
                    MatchResponse::class.java
                )

            view.showMatchList(data.events)
            view.hideLoading()
            Log.e("from Response","${data.events}")
            Log.d("from Response","${data.events}")
        }

    }


}