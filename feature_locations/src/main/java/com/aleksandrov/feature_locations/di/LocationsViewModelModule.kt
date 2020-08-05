package com.aleksandrov.feature_locations.di

import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.ViewModelKey
import com.aleksandrov.feature_locations.LocationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LocationsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    fun bindLocationsViewModel(viewModel: LocationsViewModel): ViewModel

}