package com.johnathan.challenger.api.dto

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String
)