package com.example.RickAndMortyCharactersApp.api


import com.example.RickAndMortyCharactersApp.model.CharactersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("api/character")
    suspend fun getCharacter(): Response<CharactersList>

}