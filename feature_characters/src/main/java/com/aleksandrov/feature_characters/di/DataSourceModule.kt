package com.aleksandrov.feature_characters.di

import com.aleksandrov.core.data.RickRepository
import com.aleksandrov.feature_characters.CharacterDataSource
import com.aleksandrov.feature_characters.CharacterDataSourceFactory
import dagger.Module
import dagger.Provides

@Module
object DataSourceModule {

    @Provides
    fun provideCharacterDataSource(repository: RickRepository):
            CharacterDataSource {
        return CharacterDataSource(repository)
    }

    @Provides
    fun provideCharacterDataSourceFactory(characterDataSource: CharacterDataSource):
            CharacterDataSourceFactory {
        return CharacterDataSourceFactory(characterDataSource)
    }

}