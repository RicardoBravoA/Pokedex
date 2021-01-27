package com.rba.pokedex.data.source.list

import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListLocalDataSource(private val pokedexDao: PokedexDao): PokemonListRepository {

    override suspend fun list(): ResultType<List<PokemonListModel>, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {

            try {
                val response = asteroidDao.getAsteroidList(startDate, endDate)
                return@withContext ResultType.Success(
                    AsteroidMapper.transformEntityToModel(
                        response
                    )
                )
            } catch (t: Throwable) {
                return@withContext ResultType.Error(ErrorModel())
            }
        }
    }

    override suspend fun save(list: List<PokemonListModel>) {
        TODO("Not yet implemented")
    }

}