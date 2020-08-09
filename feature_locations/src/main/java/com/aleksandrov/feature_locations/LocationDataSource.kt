package com.aleksandrov.feature_locations

import androidx.paging.PageKeyedDataSource
import com.aleksandrov.core.data.RickRepository
import com.aleksandrov.core.data.models.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationDataSource @Inject constructor(private val repository: RickRepository) :
    PageKeyedDataSource<Int, Location>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Location>
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getLocations()
                result?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        callback.onResult(result.results, null, 2)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getLocations(params.key)
                result?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        callback.onResult(result.results, params.key + 1)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
    }
}