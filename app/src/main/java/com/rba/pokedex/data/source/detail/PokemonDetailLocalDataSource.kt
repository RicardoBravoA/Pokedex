package com.rba.pokedex.data.source.detail

import com.rba.pokedex.data.mapper.PokemonDetailMapper
import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.domain.model.PokemonDetailModel
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.repository.PokemonDetailRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDetailLocalDataSource(private val pokedexDao: PokedexDao) : PokemonDetailRepository {

    override suspend fun detail(name: String): ResultType<PokemonDetailModel, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {

            try {
                val response = pokedexDao.getPokemonDetail(name)
                return@withContext ResultType.Success(
                    PokemonDetailMapper.transformEntityToModel(
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