package com.aleksandrov.core.data

import com.aleksandrov.core.data.models.CharactersResponse
import com.aleksandrov.core.data.models.EpisodesResponse
import com.aleksandrov.core.data.models.LocationsResponse
import javax.inject.Inject

class RickRepository @Inject constructor(private val service: RickService) {

    suspend fun getCharacters(): CharactersResponse {
        return service.getCharacters()
    }

    suspend fun getCharacters(pageId: Int): CharactersResponse {
        return service.getCharacters(pageId)
    }

    suspend fun getEpisodes(): EpisodesResponse {
        return service.getEpisodes()
    }

    suspend fun getEpisodes(pageId: Int): EpisodesResponse {
        return service.getEpisodes(pageId)
    }

    suspend fun getLocations(): LocationsResponse {
        return service.getLocations()
    }

    suspend fun getLocations(pageId: Int): LocationsResponse {
        return service.getLocations(pageId)
    }

}