package com.aleksandrov.feature_locations

import androidx.paging.DataSource
import com.aleksandrov.core.data.models.Location
import javax.inject.Inject

class LocationDataSourceFactory @Inject constructor(private val dataSource: LocationDataSource) :
    DataSource.Factory<Int, Location>() {
    override fun create(): DataSource<Int, Location> {
        return dataSource
    }
}