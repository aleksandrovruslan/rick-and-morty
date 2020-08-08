package com.aleksandrov.feature_characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aleksandrov.core.data.models.Character
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val factory: CharacterDataSourceFactory
) :
    ViewModel() {

    val listLiveData: LiveData<PagedList<Character>> by lazy { init() }

    private fun init(): LiveData<PagedList<Character>> {
        val pagedConfig =
            PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setPageSize(20).build()
        return LivePagedListBuilder<Int, Character>(factory, pagedConfig)
            .build()
    }

}