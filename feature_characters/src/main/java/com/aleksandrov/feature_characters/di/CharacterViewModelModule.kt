package com.aleksandrov.feature_characters.di

import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.ViewModelKey
import com.aleksandrov.feature_characters.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CharacterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    fun bindCharacterViewModel(viewModule: CharacterViewModel): ViewModel

}