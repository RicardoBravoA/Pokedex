package com.rba.pokedex.data.network

import com.rba.pokedex.data.response.PokemonDetailResponse
import com.rba.pokedex.data.response.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("pokemon")
    suspend fun pokemonList(): Response<PokemonListResponse>

    @GET("pokemon/{name}")
    suspend fun pokemonDetail(@Path("name") name: String): Response<PokemonDetailResponse>

}