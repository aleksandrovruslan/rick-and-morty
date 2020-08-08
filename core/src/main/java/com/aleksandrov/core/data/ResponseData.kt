package com.aleksandrov.core.data

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)