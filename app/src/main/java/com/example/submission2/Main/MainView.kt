package com.example.submission2.Main

import com.example.submission2.model.Match

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Match>)
}