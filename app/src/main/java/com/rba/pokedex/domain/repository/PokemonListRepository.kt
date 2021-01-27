package com.rba.pokedex.domain.repository

import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.util.ResultType

interface PokemonListRepository {

    suspend fun list(page: Int): ResultType<PokemonListModel, PokemonErrorModel>

    suspend fun save(list: PokemonListModel)
}