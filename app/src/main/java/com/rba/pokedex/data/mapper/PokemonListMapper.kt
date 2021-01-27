package com.rba.pokedex.data.mapper

import com.rba.pokedex.data.response.PokemonListResponse
import com.rba.pokedex.data.response.PokemonResponse
import com.rba.pokedex.data.storage.entity.PokemonEntity
import com.rba.pokedex.domain.model.PokemonListModel

object PokemonListMapper {

    fun transformModelToEntity(pokemonListModel: PokemonListModel): List<PokemonEntity> {
        val pokemonEntityList = mutableListOf<PokemonEntity>()

        pokemonListModel.results?.forEach {
            pokemonEntityList.add(PokemonMapper.transformPokemonModelToEntity(it))
        }

        return pokemonEntityList
    }

    fun transformEntityToModel(pokemonEntityList: List<PokemonEntity>): PokemonListModel {
        return PokemonListModel(
            null,
            null,
            null,
            PokemonMapper.transformEntityToModel(pokemonEntityList)
        )
    }

    fun transformResponseToModel(pokemonListResponse: PokemonListResponse): PokemonListModel {
        return PokemonListModel(
            null,
            null,
            null,
            PokemonMapper.transformResponseToModel(pokemonListResponse.results)
        )
    }

}