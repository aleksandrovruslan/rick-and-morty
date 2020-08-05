package com.aleksandrov.feature_episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.Episode
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val episode: Episode) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = episode.episodes
    }
    val text: LiveData<String> = _text
}