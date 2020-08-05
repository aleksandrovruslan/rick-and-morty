package com.aleksandrov.feature_episodes.di

import com.aleksandrov.core.coreComponent
import com.aleksandrov.feature_episodes.EpisodesFragment

fun EpisodesFragment.inject() {
    DaggerEpisodesComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}