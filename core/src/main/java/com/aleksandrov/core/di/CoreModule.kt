package com.aleksandrov.core.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CoreModule {

    @Singleton
    @Provides
    fun provideLocation(): Location = Location

}