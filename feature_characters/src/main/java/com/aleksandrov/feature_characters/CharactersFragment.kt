package com.aleksandrov.feature_characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aleksandrov.core.utils.ViewModelFactory
import com.aleksandrov.feature_characters.di.inject
import javax.inject.Inject

class CharactersFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        characterViewModel = ViewModelProvider(this, factory)
            .get(CharacterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        characterViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}