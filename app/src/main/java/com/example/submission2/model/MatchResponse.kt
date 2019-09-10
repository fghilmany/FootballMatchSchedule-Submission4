package com.example.submission2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

internal class MatchResponse (
    val events: List<Match>, val leagues:List<Match>, val teams:List<Match>, val event:List<Match>)