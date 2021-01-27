package com.rba.pokedex.data.mapper

import com.rba.pokedex.data.response.PokemonErrorResponse
import com.rba.pokedex.domain.model.PokemonErrorModel

object PokemonErrorMapper {

    fun transformResponseToModel(pokemonErrorResponse: PokemonErrorResponse): PokemonErrorModel {
        pokemonErrorResponse.apply {
            return PokemonErrorModel(code, message)
        }
    }

}