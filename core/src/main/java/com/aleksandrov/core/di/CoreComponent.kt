package com.aleksandrov.core.di

import android.app.Application
import com.aleksandrov.core.data.RickDataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RickDataModule::class])
interface CoreComponent : CoreComponentProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }

}