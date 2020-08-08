package com.aleksandrov.feature_episodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrov.core.data.models.Episode

class EpisodePagedListAdapter() : PagedListAdapter<Episode, EpisodeViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Episode>() {
    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.id == newItem.id
    }

}

class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.name)
    private val airDate: TextView = itemView.findViewById(R.id.air_date)
    private val _episode: TextView = itemView.findViewById(R.id.episode)

    fun onBind(episode: Episode) {
        name.text = episode.name
        airDate.text = episode.airDate
        _episode.text = episode.episode
    }

}