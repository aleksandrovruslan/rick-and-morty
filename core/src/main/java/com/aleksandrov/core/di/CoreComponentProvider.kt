package com.aleksandrov.core.di

interface CoreComponentProvider {

    fun provideCharacter(): Character
    fun provideEpisode(): Episode
    fun provideLocation(): Location

}