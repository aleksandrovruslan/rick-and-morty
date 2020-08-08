package com.aleksandrov.core.data

import javax.inject.Inject

class RickRepository @Inject constructor(private val service: RickService) {

    suspend fun getCharacters() : ResponseData {
        return service.getCharacters()
    }

    suspend fun getCharacters(pageId:Int):ResponseData {
        return service.getCharacters(pageId)
    }

}