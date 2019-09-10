package com.example.submission2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Match (

    @SerializedName("idEvent")
    var eventId: String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam: String? = null,

    @SerializedName("strAwayTeam")
    var awayTeam: String? = null,

    @SerializedName("intHomeScore")
    var homeScore: Int? = 0,

    @SerializedName("intAwayScore")
    var awayScore: Int? = 0,

    @SerializedName("dateEvent")
    var dateEvent: String? = null,

    @SerializedName("strBadge")
    var leagueBadge: String? = null,

    @SerializedName("strLeague")
    var nameLeague: String? = null,

    @SerializedName("strDescriptionEN")
    var descLeague: String? = null,

    @SerializedName("strHomeFormation")
    var homeFormation: String? = null,

    @SerializedName("strHomeGoalDetails")
    var homeGoal : String? = null,

    @SerializedName("strAwayFormation")
    var awayFormation: String? = null,

    @SerializedName("strAwayGoalDetails")
    var awayGoal : String? = null,

    @SerializedName("strThumb")
    var thumbLeague : String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge : String? = null



)