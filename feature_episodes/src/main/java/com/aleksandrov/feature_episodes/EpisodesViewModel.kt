package com.aleksandrov.feature_episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aleksandrov.core.data.models.Episode
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(
    private val dataSourceFactory: EpisodesDataSourceFactory
) :
    ViewModel() {

    val listLiveData: LiveData<PagedList<Episode>> by lazy { init() }

    private fun init(): LiveData<PagedList<Episode>> {
        val listConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .build()
        return LivePagedListBuilder<Int, Episode>(dataSourceFactory, listConfig)
            .build()
    }

}