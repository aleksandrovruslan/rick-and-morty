package com.aleksandrov.feature_characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrov.core.data.models.Character
import com.bumptech.glide.Glide

class CharacterPagedListAdapter :
    PagedListAdapter<Character, CharactersViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }
}

class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val characterImage: ImageView = itemView.findViewById(R.id.character_img)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val status: TextView = itemView.findViewById(R.id.status)
    private val species: TextView = itemView.findViewById(R.id.species)
    private val origin: TextView = itemView.findViewById(R.id.origin)
    private val location: TextView = itemView.findViewById(R.id.location)

    fun onBind(character: Character) {
        name.text = character.name
        status.text = "status: ${character.status}"
        species.text = "species: ${character.species}"
        origin.text = "origin location: ${character.origin.name}"
        location.text = "location: ${character.location.name}"
        Glide.with(itemView)
            .load(character.image)
            .into(characterImage)
    }

}