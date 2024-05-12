package com.example.pokego.network

import com.example.pokego.model.PokemonDetails
import com.example.pokego.model.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemons(@Query("limit") limit: Int): PokemonsResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): PokemonDetails
}