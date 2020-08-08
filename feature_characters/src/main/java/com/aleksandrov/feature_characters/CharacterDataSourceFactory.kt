package com.aleksandrov.feature_characters

import androidx.paging.DataSource
import com.aleksandrov.core.data.models.Character
import javax.inject.Inject

class CharacterDataSourceFactory @Inject constructor(
    private val dataSource: CharacterDataSource
) :
    DataSource.Factory<Int, Character>() {

    override fun create(): DataSource<Int, Character> {
        return dataSource
    }

}