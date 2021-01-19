package com.rba.pokedex.data.mapper

import com.rba.pokedex.data.response.PokemonResponse
import com.rba.pokedex.data.storage.entity.PokemonEntity
import com.rba.pokedex.data.util.url
import com.rba.pokedex.domain.model.PokemonModel

object PokemonMapper {

    fun transformModelToEntity(pokemonModelList: List<PokemonModel>): List<PokemonEntity> {
        val pokemonEntityList = mutableListOf<PokemonEntity>()

        pokemonModelList.forEach {
            pokemonEntityList.add(transformPokemonModelToEntity(it))
        }
        return pokemonEntityList
    }

    fun transformPokemonModelToEntity(pokemonModel: PokemonModel): PokemonEntity {
        pokemonModel.apply {
            return PokemonEntity(name, page, url)
        }

    }

    fun transformEntityToModel(pokemonEntityList: List<PokemonEntity>): List<PokemonModel> {
        val pokemonModelList = mutableListOf<PokemonModel>()

        pokemonEntityList.forEach {
            pokemonModelList.add(transformPokemonEntityToModel(it))
        }
        return pokemonModelList
    }

    private fun transformPokemonEntityToModel(pokemonEntity: PokemonEntity): PokemonModel {
        pokemonEntity.apply {
            return PokemonModel(name, page, url)
        }
    }

    fun transformResponseToModel(pokemonResponseList: List<PokemonResponse>): List<PokemonModel> {
        val pokemonModelList = mutableListOf<PokemonModel>()

        pokemonResponseList.forEach {
            pokemonModelList.add(transformPokemonResponseToModel(it))
        }
        return pokemonModelList
    }

    private fun transformPokemonResponseToModel(pokemonResponse: PokemonResponse): PokemonModel {
        pokemonResponse.apply {
            return PokemonModel(name, page, url.url())
        }
    }

}