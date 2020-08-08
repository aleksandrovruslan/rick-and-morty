package com.aleksandrov.core.data.models

import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val charactersUrl: List<String>
)