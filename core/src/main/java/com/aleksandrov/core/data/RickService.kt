package com.aleksandrov.core.data

import com.aleksandrov.core.data.models.Character
import com.aleksandrov.core.data.models.CharactersResponse
import com.aleksandrov.core.data.models.EpisodesResponse
import com.aleksandrov.core.data.models.LocationsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickService {

    @GET("character/")
    suspend fun getCharacters(): CharactersResponse

    @GET("character/")
    suspend fun getCharacters(@Query("page") pageId: Int): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character

    @GET("episode/")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("episode/")
    suspend fun getEpisodes(@Query("page") pageId: Int): EpisodesResponse

    @GET("location/")
    suspend fun getLocations(): LocationsResponse

    @GET("location/")
    suspend fun getLocations(@Query("page") pageId: Int): LocationsResponse

    companion object {
        const val ENDPOINT = "https://rickandmortyapi.com/api/"
    }

}