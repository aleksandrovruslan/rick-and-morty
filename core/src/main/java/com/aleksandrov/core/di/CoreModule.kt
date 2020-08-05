package com.aleksandrov.core.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CoreModule {

    @Singleton
    @Provides
    fun provideCharacter(): Character = Character

    @Singleton
    @Provides
    fun provideEpisode(): Episode = Episode

    @Singleton
    @Provides
    fun provideLocation(): Location = Location

}