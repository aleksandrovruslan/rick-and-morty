package com.aleksandrov.core.di

import com.aleksandrov.core.data.RickRepository

interface CoreComponentProvider {

    fun provideLocation(): Location
    fun provideRickRepository(): RickRepository

}