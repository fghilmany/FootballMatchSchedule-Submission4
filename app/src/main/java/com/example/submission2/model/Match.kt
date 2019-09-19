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

    @SerializedName("strLeague")
    var nameLeague: String? = null,

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
    var teamBadge : String? = null,

    @SerializedName("strEvent")
    var eventVS : String? = null,

    @SerializedName("idLeague")
    var idLeague: String? = null,

    @SerializedName("strSport")
    var strSport: String? = null,

    @SerializedName("strHomeYellowCards")
    var homeYCard: String? = null,

    @SerializedName("strAwayYellowCards")
    var awayYCard: String? = null,

    @SerializedName("strHomeRedCards")
    var homeRCard: String? = null,

    @SerializedName("strAwayRedCards")
    var awayRCard: String? = null



)