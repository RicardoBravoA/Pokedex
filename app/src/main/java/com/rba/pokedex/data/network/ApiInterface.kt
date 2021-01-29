package com.rba.pokedex.data.network

import com.rba.pokedex.data.response.PokemonDetailResponse
import com.rba.pokedex.data.response.PokemonListResponse
import com.rba.pokedex.data.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("pokemon")
    suspend fun pokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = Constant.POKEMON_LIMIT
    ): Response<PokemonListResponse>

    @GET("pokemon/{name}")
    suspend fun pokemonDetail(@Path("name") name: String): Response<PokemonDetailResponse>

}