package com.example.submission2.Main

import android.util.Log
import com.example.submission2.api.ApiRepository
import com.example.submission2.api.TheSportDBApi
import com.example.submission2.model.MatchResponse
import com.example.submission2.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.coroutines.CoroutineContext

class MainPresenter (
    private val view: MainView ,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()){

    fun getPrevMatch(league:String?){
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPrevMatch(league)).await(),
                MatchResponse::class.java
            )

            view.hideLoading()
            view.showMatchList(data.events)

            Log.e("from response main","${data.events}")

        }
    }

    fun getNextMatch(league: String?){
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(league)).await(),
                MatchResponse::class.java
            )

            view.hideLoading()
            view.showMatchList(data.events)

        }
    }

    fun getDetailLeague(league: String?){
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeagueDetail(league)).await(),
                MatchResponse::class.java
            )

            view.hideLoading()
            view.showMatchList(data.leagues)

        }
    }

    fun getSearchTeam(league: String?){  //dipakai juga untuk yambah gambar di detailMatch
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchTeam(league)).await(),
                MatchResponse::class.java
            )

            view.hideLoading()
            view.showMatchList(data.event)

        }

    }
}
