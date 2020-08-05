package com.aleksandrov.feature_locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.Location
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val location: Location) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = location.locaion
    }
    val text: LiveData<String> = _text

}