package com.example.pokego.network

import com.example.pokego.model.PokemonDetails
import com.example.pokego.model.PokemonsResponse

class PokemonsRepository {
    private val api: PokemonApi by lazy { Retrofit.getClient().create(PokemonApi::class.java) }

    suspend fun getPokemons(): PokemonsResponse {
        return api.getPokemons(limit = 60)
    }
    suspend fun getPokemonDetailsByName(name: String): PokemonDetails {
        return api.getPokemonByName(name)
    }

}