package com.example.RickAndMortyCharactersApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.RickAndMortyCharactersApp.adapter.CharacterAdapter
import com.example.RickAndMortyCharactersApp.databinding.ActivityMainBinding
import com.example.RickAndMortyCharactersApp.repository.Repository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { CharacterAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCharacter()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                myAdapter.setData(response.body()!!.results)
            }
        })

    }


    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }
}