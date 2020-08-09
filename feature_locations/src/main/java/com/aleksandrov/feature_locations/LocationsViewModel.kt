package com.aleksandrov.feature_locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aleksandrov.core.data.models.Location
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val factory: LocationDataSourceFactory) :
    ViewModel() {

    val locationLiveData: LiveData<PagedList<Location>> by lazy { init() }

    private fun init(): LiveData<PagedList<Location>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .build()
        return LivePagedListBuilder<Int, Location>(factory, config)
            .build()
    }

}