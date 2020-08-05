package com.aleksandrov.core

import android.app.Activity
import androidx.fragment.app.Fragment
import com.aleksandrov.core.di.CoreComponentProvider

interface App {

    fun getCoreComponent(): CoreComponentProvider

}

fun Activity.coreComponent(): CoreComponentProvider =
    (applicationContext as App).getCoreComponent()

fun Fragment.coreComponent(): CoreComponentProvider =
    (activity?.applicationContext as App).getCoreComponent()