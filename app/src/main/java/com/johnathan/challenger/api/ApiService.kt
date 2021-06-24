package com.johnathan.challenger.api

import com.johnathan.challenger.api.dto.FilmResult
import com.johnathan.challenger.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v3/{uid}")
    suspend fun getFilms(@Path("uid") uid: String): FilmResult
}

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service : ApiService = retrofit.create(ApiService::class.java)