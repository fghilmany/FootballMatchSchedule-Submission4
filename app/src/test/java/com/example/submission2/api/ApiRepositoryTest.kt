package com.example.submission2.api

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

class ApiRepositoryTest {

    @Test
    fun doRequest() {
        val apiRepo = Mockito.mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"

        apiRepo.doRequest(url)
        Mockito.verify(apiRepo).doRequest(url)
    }
}