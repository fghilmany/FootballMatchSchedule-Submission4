package com.example.submission2.fragment.favorite

data class Favorite(
    val id: Long?,
    val matchId: String?,
    val teamHomeName : String?,
    val teamHomeScore : String?,
    val teamAwayName: String?,
    val teamAwayScore: String?,
    val dateMatch : String?) {

    companion object{
        const val TABLE_FAVORITE : String = "TABLE_FAVORITE"
        const val ID : String = "ID_"
        const val MATCH_ID : String = "MATCH_ID"
        const val TEAM_HOME_NAME : String = "TEAM_HOME_NAME"
        const val TEAM_HOME_SCORE : String = "TEAM_HOME_SCORE"
        const val TEAM_AWAY_NAME : String = "TEAM_AWAY_NAME"
        const val TEAM_AWAY_SCORE : String = "TEAM_AWAY_SCORE"
        const val DATE_MATCH : String = "MATCH_DATE"

    }

}