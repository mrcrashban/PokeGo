package com.example.pokego.model

data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemons>
)
