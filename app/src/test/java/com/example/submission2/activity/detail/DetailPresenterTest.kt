package com.example.submission2.activity.detail

import com.example.submission2.Main.MainPresenter
import com.example.submission2.Main.MainView
import com.example.submission2.api.ApiRepository
import com.example.submission2.model.Match
import com.example.submission2.model.MatchResponse
import com.example.submission2.utils.TestContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailPresenterTest {
    @Mock
    private lateinit var view : DetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view, apiRepository, gson, TestContextProvider())
    }


    @Test
    fun getHomeTeamBadge() {
        val event : MutableList<Match> = mutableListOf()
        val events : MutableList<Match> = mutableListOf()
        val leagues : MutableList<Match> = mutableListOf()
        val teams : MutableList<Match> = mutableListOf()
        val response = MatchResponse(events, event, leagues, teams)
        val nameClub = "arsenal"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    MatchResponse::class.java
                )
            ).thenReturn(response)

            presenter.getDetailEvent(nameClub)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getAwayTeamBadge() {
        val event : MutableList<Match> = mutableListOf()
        val events : MutableList<Match> = mutableListOf()
        val leagues : MutableList<Match> = mutableListOf()
        val teams : MutableList<Match> = mutableListOf()
        val response = MatchResponse(events, event, leagues, teams)
        val nameClub = "arsenal"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    MatchResponse::class.java
                )
            ).thenReturn(response)

            presenter.getAwayTeamBadge(nameClub)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getDetailEvent() {
        val event : MutableList<Match> = mutableListOf()
        val events : MutableList<Match> = mutableListOf()
        val leagues : MutableList<Match> = mutableListOf()
        val teams : MutableList<Match> = mutableListOf()
        val response = MatchResponse(events, event, leagues, teams)
        val idLeague = "4328"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    MatchResponse::class.java
                )
            ).thenReturn(response)

            presenter.getHomeTeamBadge(idLeague)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }
    }
}