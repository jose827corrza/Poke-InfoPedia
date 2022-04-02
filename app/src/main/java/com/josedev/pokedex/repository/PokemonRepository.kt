package com.josedev.pokedex.repository

import com.josedev.pokedex.data.remote.PokemonApi
import com.josedev.pokedex.data.remote.responses.Pokemon
import com.josedev.pokedex.data.remote.responses.PokemonList
import com.josedev.pokedex.util.ResourceClass
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
){
    suspend fun  getPokemonList(limit: Int, offset: Int): ResourceClass<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return  ResourceClass.Error("Ha ocurreido un error")
        }
        return ResourceClass.Success(response)
    }

    suspend fun  getPokemonInfo(pokemonName: String): ResourceClass<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return  ResourceClass.Error("Ha ocurreido un error")
        }
        return ResourceClass.Success(response)
    }
}