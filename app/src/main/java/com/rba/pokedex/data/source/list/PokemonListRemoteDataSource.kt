package com.rba.pokedex.data.source.list

import com.rba.pokedex.data.mapper.PokemonListMapper
import com.rba.pokedex.data.network.ApiManager
import com.rba.pokedex.data.storage.database.PokedexDao
import com.rba.pokedex.domain.model.PokemonErrorModel
import com.rba.pokedex.domain.model.PokemonListModel
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListRemoteDataSource(private val pokedexDao: PokedexDao) : PokemonListRepository {

    override suspend fun list(page: Int): ResultType<PokemonListModel, PokemonErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = ApiManager.get().pokemonList(page)
                if (response.isSuccessful) {
                    val pictureOfTheDayResponse = response.body()!!
                    savePicture(
                        PictureMapper.transformResponseToModel(
                            pictureOfTheDayResponse
                        )
                    )
                    ResultType.Success(
                        PictureMapper.transformResponseToModel(
                            pictureOfTheDayResponse
                        )
                    )
                } else {
                    val error = RetrofitErrorUtil.parseError(response)!!
                    ResultType.Error(ErrorMapper.transformResponseToModel(error))
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

}