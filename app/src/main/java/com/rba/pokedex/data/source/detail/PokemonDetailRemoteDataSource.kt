package com.rba.pokedex.data.source.detail

import com.rba.pokedex.data.mapper.PokemonErrorMapper
import com.rba.pokedex.data.mapper.PokemonListMapper
import com.rba.pokedex.data.network.ApiManager
import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.data.util.ErrorUtil
import com.rba.pokedex.data.util.RetrofitErrorUtil
import com.rba.pokedex.domain.model.PokemonDetailModel
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.repository.PokemonDetailRepository
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDetailRemoteDataSource(private val pokedexDao: PokedexDao) : PokemonDetailRepository {

    override suspend fun list(page: Int): ResultType<PokemonListModel, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = ApiManager.get().pokemonList(page)
                if (response.isSuccessful) {
                    val response = response.body()!!
                    save(
                        PokemonListMapper.transformResponseToModel(
                            response
                        )
                    )
                    ResultType.Success(
                        PokemonListMapper.transformResponseToModel(
                            response
                        )
                    )
                } else {
                    val error = RetrofitErrorUtil.parseError(response)!!
                    ResultType.Error(PokemonErrorMapper.transformResponseToModel(error))
                }

            } catch (t: Throwable) {
                ResultType.Error(ErrorUtil.errorHandler(t))
            }
        }
    }

    override suspend fun save(list: PokemonListModel) {
        return withContext(Dispatchers.IO) {
            pokedexDao.insertPokemon(
                PokemonListMapper.transformModelToEntity(list)
            )
        }
    }

    override suspend fun detail(name: String): ResultType<PokemonDetailModel, PokemonErrorModel> {
        TODO("Not yet implemented")
    }

    override suspend fun save(pokemonDetailModel: PokemonDetailModel) {
        return withContext(Dispatchers.IO) {
            pokedexDao.insertPokemon(
                PokemonListMapper.transformModelToEntity(list)
            )
        }
    }

}