package com.aleksandrov.core.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickService {

    @GET("character/")
    suspend fun getCharacters(): ResponseData

    @GET("character/")
    suspend fun getCharacters(@Query("page") pageId: Int): ResponseData

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character

    companion object {
        const val ENDPOINT = "https://rickandmortyapi.com/api/"
    }

}