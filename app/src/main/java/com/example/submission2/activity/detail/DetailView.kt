package com.example.submission2.activity.detail

import com.example.submission2.model.Match

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Match>)
    fun showHomeBadge(data: List<Match>)
    fun showAwayBadge(data: List<Match>)
}