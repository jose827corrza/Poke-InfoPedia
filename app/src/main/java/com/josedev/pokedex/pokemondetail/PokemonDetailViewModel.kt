package com.josedev.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.josedev.pokedex.data.remote.responses.Pokemon
import com.josedev.pokedex.repository.PokemonRepository
import com.josedev.pokedex.util.ResourceClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {


    suspend fun getPokemonInfo(pokemonName: String): ResourceClass<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}