package com.aleksandrov.core.di

import androidx.lifecycle.ViewModelProvider
import com.aleksandrov.core.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}