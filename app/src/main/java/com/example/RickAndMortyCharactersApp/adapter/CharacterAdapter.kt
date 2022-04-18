package com.example.RickAndMortyCharactersApp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittestingappgetrequest.R
import com.example.retrofittestingappgetrequest.databinding.RowLayoutBinding
import com.example.RickAndMortyCharactersApp.model.Character
import com.squareup.picasso.Picasso


import okhttp3.internal.wait

class CharacterAdapter(private val context: Context) :
    RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var myList = emptyList<Character>()


    class MyViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.nameTxt.text = character.name
            binding.gender.text = character.gender
            binding.speciesTxt.text = character.species
            Picasso.get().load(character.image).into(binding.imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myList[position])
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Character>) {
        myList = newList
        notifyDataSetChanged()
    }

}
