package com.aleksandrov.rick_and_morty

import android.app.Application
import com.aleksandrov.core.App
import com.aleksandrov.core.di.CoreComponentProvider
import com.aleksandrov.core.di.DaggerCoreComponent

class RickApplication : Application(), App {

    private val component: CoreComponentProvider by lazy { DaggerCoreComponent.create() }

    override fun getCoreComponent(): CoreComponentProvider {
        return component
    }

}