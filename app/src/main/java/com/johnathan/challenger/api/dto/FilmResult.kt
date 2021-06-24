package com.johnathan.challenger.api.dto

import com.google.gson.annotations.SerializedName

data class FilmResult(
    @SerializedName("results") var films: MutableList<Film>
)