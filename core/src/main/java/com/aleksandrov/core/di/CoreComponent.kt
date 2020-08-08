package com.aleksandrov.core.di

import com.aleksandrov.core.data.RickDataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, RickDataModule::class])
interface CoreComponent : CoreComponentProvider