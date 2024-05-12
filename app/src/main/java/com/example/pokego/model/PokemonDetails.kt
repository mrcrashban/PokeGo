package com.example.pokego.model

import com.google.gson.annotations.SerializedName

data class PokemonDetails(
    val id: Int,
    val name: String,
    val weight: String,
    val height: String,
    val sprites: Image
)

data class Image(
    @SerializedName("front_default")
    val frontDefault: String?
)
