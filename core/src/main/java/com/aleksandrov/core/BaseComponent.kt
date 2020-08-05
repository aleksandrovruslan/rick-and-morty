package com.aleksandrov.core

import androidx.fragment.app.Fragment

interface BaseComponent<T> {
    fun inject(t: T)
}

interface BaseFragmentComponent<T : Fragment> : BaseComponent<T>