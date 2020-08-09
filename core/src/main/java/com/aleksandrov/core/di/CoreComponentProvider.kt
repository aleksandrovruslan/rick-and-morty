package com.aleksandrov.core.di

import com.aleksandrov.core.data.RickRepository

interface CoreComponentProvider {

    fun provideRickRepository(): RickRepository

}