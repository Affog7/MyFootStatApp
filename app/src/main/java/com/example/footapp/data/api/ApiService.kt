package com.example.footapp.data.api

import com.example.footapp.models.Joueur
import com.example.footapp.models.ListJoueur
import com.example.footapp.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    fun getJoueurs(
        @Query("action") action : String = Constants.ACTION_DEFAULT,
        @Query("APIkey") key : String = Constants.API_KEY,
        @Query("team_id") team_id : String = Constants.TEAM_ID,
        @Query("league_id") league_id : String = Constants.LEAGUE_ID
    ) : Call<MutableList<ListJoueur>>


    @GET("/")
    fun getJoueurById(
        @Query("action") action : String = Constants.ACTION_PL_BY_ID,
        @Query("APIkey") key : String = Constants.API_KEY,
        @Query("player_id") player_id : Long,
    ) : Call<MutableList<Joueur>>
}