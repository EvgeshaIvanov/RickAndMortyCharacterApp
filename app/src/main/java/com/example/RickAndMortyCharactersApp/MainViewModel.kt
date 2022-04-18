package com.example.RickAndMortyCharactersApp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.RickAndMortyCharactersApp.model.CharactersList
import com.example.RickAndMortyCharactersApp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<CharactersList>> = MutableLiveData()

    fun getCharacter() {
        viewModelScope.launch {
            val response = repository.getCharacter()
            myResponse.value = response
        }
    }
}