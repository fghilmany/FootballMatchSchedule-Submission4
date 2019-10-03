package com.example.submission2.Main

import com.example.submission2.api.ApiRepository
import com.example.submission2.api.TheSportDBApi
import com.example.submission2.model.Match
import com.example.submission2.model.MatchResponse
import com.example.submission2.utils.TestContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.*
import org.mockito.Mockito.*

class MainPresenterTest {

    @Mock
    private lateinit var view : MainView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter: MainPresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun getPrevMatch() {
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

            presenter.getPrevMatch(idLeague)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }

    }

    @Test
    fun getNextMatch() {
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

            presenter.getNextMatch(idLeague)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }


    }

    @Test
    fun getDetailLeague() {
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

            presenter.getDetailLeague(idLeague)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }

    }

    @Test
    fun getSearchTeam() {
        val event : MutableList<Match> = mutableListOf()
        val events : MutableList<Match> = mutableListOf()
        val leagues : MutableList<Match> = mutableListOf()
        val teams : MutableList<Match> = mutableListOf()
        val response = MatchResponse(events, event, leagues, teams)
        val nameLeague = "arsenal"

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

            presenter.getSearchTeam(nameLeague)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(events)
            Mockito.verify(view).hideLoading()
        }

    }
}