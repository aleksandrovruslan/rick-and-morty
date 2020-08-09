package com.aleksandrov.feature_locations

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
import com.aleksandrov.feature_locations.di.inject
import javax.inject.Inject

class LocationsFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var locationsViewModel: LocationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        locationsViewModel = ViewModelProvider(this, factory)
            .get(LocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_locations, container, false)
        val recycler: RecyclerView = root.findViewById(R.id.locations_recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = LocationPagedListAdapter()
        recycler.adapter = adapter
        locationsViewModel.locationLiveData.observe(
            viewLifecycleOwner,
            Observer { adapter.submitList(it) })
        return root
    }
}