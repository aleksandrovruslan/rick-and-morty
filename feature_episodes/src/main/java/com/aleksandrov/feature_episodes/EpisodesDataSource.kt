package com.aleksandrov.feature_episodes

import androidx.paging.PageKeyedDataSource
import com.aleksandrov.core.data.RickRepository
import com.aleksandrov.core.data.models.Episode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesDataSource @Inject constructor(private val repository: RickRepository) :
    PageKeyedDataSource<Int, Episode>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Episode>
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getEpisodes()
                result?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        callback.onResult(result.results, 0, 2)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        try {
            GlobalScope.launch(Dispatchers.IO) {
                val result = repository.getEpisodes(params.key)
                result?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        callback.onResult(result.results, params.key + 1)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        if (params.key < 2) {
            callback.onResult(ArrayList(), 1)
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                val result = repository.getEpisodes(params.key)
                result?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        callback.onResult(result.results, params.key - 1)
                    }
                }
            }
        }
    }
}