package com.aleksandrov.feature_characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrov.core.utils.ViewModelFactory
import com.aleksandrov.feature_characters.di.inject
import javax.inject.Inject


class CharactersFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: CharacterPagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        characterViewModel = ViewModelProvider(this, factory)
            .get(CharacterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)
        recycler = root.findViewById(R.id.characters_recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = CharacterPagedListAdapter()
        recycler.adapter = adapter
        characterViewModel.listLiveData.observe(
            viewLifecycleOwner, Observer { adapter.submitList(it) }
        )
        return root
    }
}