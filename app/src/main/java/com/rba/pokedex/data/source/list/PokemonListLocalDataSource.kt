package com.rba.pokedex.data.source.list

import com.rba.pokedex.data.mapper.PokemonListMapper
import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListLocalDataSource(private val pokedexDao: PokedexDao) : PokemonListRepository {

    override suspend fun list(page: Int): ResultType<PokemonListModel, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {

            try {
                val response = pokedexDao.getAllPokemon()
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

    override suspend fun save(list: PokemonListModel) {
        //Do nothing
    }

}