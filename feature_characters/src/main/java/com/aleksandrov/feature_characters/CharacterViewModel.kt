package com.aleksandrov.feature_characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aleksandrov.core.di.Character
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val character: Character) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = character.character
    }
    val text: LiveData<String> = _text

}