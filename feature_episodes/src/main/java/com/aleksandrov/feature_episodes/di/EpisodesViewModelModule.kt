package com.aleksandrov.feature_episodes.di

import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.ViewModelKey
import com.aleksandrov.feature_episodes.EpisodesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface EpisodesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    fun bindEpisodesViewModel(viewModel: EpisodesViewModel): ViewModel

}