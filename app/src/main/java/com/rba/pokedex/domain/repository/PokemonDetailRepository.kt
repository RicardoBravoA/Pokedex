package com.rba.pokedex.domain.repository

import com.rba.pokedex.domain.model.PokemonDetailModel
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.util.ResultType

interface PokemonDetailRepository {

    suspend fun detail(name: String): ResultType<PokemonDetailModel, PokemonErrorModel>

    suspend fun save(pokemonDetailModel: PokemonDetailModel)

}