package com.example.RickAndMortyCharactersApp.repository

import com.example.RickAndMortyCharactersApp.api.RetrofitInstance
import com.example.RickAndMortyCharactersApp.model.Character
import com.example.RickAndMortyCharactersApp.model.CharactersList
import retrofit2.Response

class Repository {

    suspend fun getCharacter(): Response<CharactersList> {
        return RetrofitInstance.api.getCharacter()
    }
}