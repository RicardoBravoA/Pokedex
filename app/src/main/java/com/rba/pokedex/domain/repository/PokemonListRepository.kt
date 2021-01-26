package com.rba.pokedex.domain.repository

import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.util.ResultType

interface PokemonListRepository {

    suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<PokemonListModel>, PokemonErrorModel>

    suspend fun saveAsteroid(list: List<PokemonListModel>)
}