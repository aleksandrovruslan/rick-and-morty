package com.aleksandrov.feature_episodes

import androidx.paging.DataSource
import com.aleksandrov.core.data.models.Episode
import javax.inject.Inject


class EpisodesDataSourceFactory @Inject constructor(private val dataSource: EpisodesDataSource) :
    DataSource.Factory<Int, Episode>() {
    override fun create(): DataSource<Int, Episode> {
        return dataSource
    }
}