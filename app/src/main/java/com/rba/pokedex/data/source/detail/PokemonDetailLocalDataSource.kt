package com.rba.pokedex.data.source.detail

import com.rba.pokedex.data.mapper.PokemonListMapper
import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.domain.model.PokemonDetailModel
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.repository.PokemonDetailRepository
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDetailLocalDataSource(private val pokedexDao: PokedexDao) : PokemonDetailRepository {

    override suspend fun detail(name: String): ResultType<PokemonDetailModel, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {

            try {
                val response = pokedexDao.getAllPokemon(page)
                return@withContext ResultType.Success(
                    PokemonListMapper.transformEntityToModel(
                        response
                    )
                )
            } catch (t: Throwable) {
                return@withContext ResultType.Error(PokemonErrorModel())
            }
        }
    }

    override suspend fun save(pokemonDetailModel: PokemonDetailModel) {
        //Do nothing
    }

}