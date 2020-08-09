package com.aleksandrov.feature_locations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrov.core.data.models.Location

class LocationPagedListAdapter : PagedListAdapter<Location, LocationViewHolder>(DiffCalBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

class DiffCalBack : DiffUtil.ItemCallback<Location>() {
    override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem.equals(newItem)
    }
}

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.name)
    private val type: TextView = itemView.findViewById(R.id.type)
    private val dimension: TextView = itemView.findViewById(R.id.dimension)

    fun onBind(location: Location) {
        name.text = location.name
        type.text = location.type
        dimension.text = location.dimension
    }

}