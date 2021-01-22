package com.rba.pokedex.data.mapper

import com.rba.pokedex.data.response.PokemonDetailResponse
import com.rba.pokedex.data.storage.entity.PokemonDetailEntity
import com.rba.pokedex.domain.model.PokemonDetailModel

object PokemonDetailMapper {

    fun transformModelToEntity(pokemonDetailModel: PokemonDetailModel): PokemonDetailEntity {
        pokemonDetailModel.apply {
            return PokemonDetailEntity(
                id,
                name,
                height,
                weight,
                experience,
                transformTypeModelToTypeResponseEntityList(types),
                hp,
                attack,
                defense,
                speed
            )
        }
    }

    private fun transformTypeModelToTypeResponseEntityList(typeModelList: List<PokemonDetailModel.TypeModel>)
            : List<PokemonDetailEntity.TypeResponseEntity> {
        val typeResponseList = mutableListOf<PokemonDetailEntity.TypeResponseEntity>()

        typeModelList.forEach {
            typeResponseList.add(transformTypeModelToTypeResponse(it))
        }
        return typeResponseList
    }

    private fun transformTypeModelToTypeResponse(typeModel: PokemonDetailModel.TypeModel)
            : PokemonDetailEntity.TypeResponseEntity {
        typeModel.apply {
            return PokemonDetailEntity.TypeResponseEntity(slot, name)
        }
    }

    fun transformEntityToModel(pokemonDetailEntity: PokemonDetailEntity): PokemonDetailModel {
        pokemonDetailEntity.apply {
            return PokemonDetailModel(
                id,
                name,
                height,
                weight,
                experience,
                transformTypeResponseToTypeModelList(types),
                hp,
                attack,
                defense,
                speed
            )
        }
    }

    private fun transformTypeResponseToTypeModelList(typeResponseList: List<PokemonDetailEntity.TypeResponseEntity>)
            : List<PokemonDetailModel.TypeModel> {
        val typeModelList = mutableListOf<PokemonDetailModel.TypeModel>()

        typeResponseList.forEach {
            typeModelList.add(transformTypeResponseToTypeModel(it))
        }
        return typeModelList
    }

    private fun transformTypeResponseToTypeModel(typeResponse: PokemonDetailEntity.TypeResponseEntity)
            : PokemonDetailModel.TypeModel {
        typeResponse.apply {
            return PokemonDetailModel.TypeModel(slot, name)
        }
    }

    fun transformResponseToModel(pokemonDetailResponse: PokemonDetailResponse): PokemonDetailModel {

    }

}