package com.aleksandrov.feature_characters.di

import com.aleksandrov.core.coreComponent
import com.aleksandrov.feature_characters.CharactersFragment

fun CharactersFragment.inject() {
    DaggerCharacterComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}