package com.aleksandrov.feature_episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aleksandrov.core.utils.ViewModelFactory
import com.aleksandrov.feature_episodes.di.inject
import javax.inject.Inject

class EpisodesFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var episodesViewModel: EpisodesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        episodesViewModel = ViewModelProvider(this, factory).get(EpisodesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_episodes, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        episodesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}