package com.example.pokego.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokego.model.PokemonDetails
import com.example.pokego.network.PokemonsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonsRepository: PokemonsRepository = PokemonsRepository()) :
    ViewModel() {
    private val _pokemonUiState = MutableStateFlow(emptyList<PokemonDetails>())
    val pokemonUiState = _pokemonUiState.asStateFlow()

    fun getAllPokemons() {
        viewModelScope.launch(CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler got $exception")
        }) {
            try {
                val pokemonsResponse = pokemonsRepository.getPokemons()
                val pokemonDetailsList = mutableListOf<PokemonDetails>()
                for (pokemon in pokemonsResponse.results) {
                    val details = pokemonsRepository.getPokemonDetailsByName(pokemon.name)
                    pokemonDetailsList.add(details)
                }
                _pokemonUiState.value = pokemonDetailsList
            } catch (e: Exception) {
                println("Exception: $e")
            }
        }
    }
}