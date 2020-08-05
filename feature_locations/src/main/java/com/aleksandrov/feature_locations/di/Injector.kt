package com.aleksandrov.feature_locations.di

import com.aleksandrov.core.coreComponent
import com.aleksandrov.feature_locations.LocationsFragment

fun LocationsFragment.inject() {
    DaggerLocationsComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}