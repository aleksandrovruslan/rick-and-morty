package com.aleksandrov.core.di

import com.aleksandrov.core.data.RickRepository

interface CoreComponentProvider {

    fun provideCharacter(): Character
    fun provideEpisode(): Episode
    fun provideLocation(): Location
    fun provideRickRepository(): RickRepository

}