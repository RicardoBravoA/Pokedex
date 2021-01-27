package com.rba.pokedex.data.util

import com.rba.pokedex.domain.model.PokemonErrorModel

object ErrorUtil {

    fun errorHandler(error: Throwable): PokemonErrorModel {

        val errorException: RetrofitException =
            if (error is RetrofitException) {
                error
            } else {
                RetrofitException.retrofitException(error)
            }

        return when (errorException.kind) {
            RetrofitException.Kind.HTTP -> errorException.getErrorBodyAs(PokemonErrorModel::class.java)!!
            RetrofitException.Kind.NETWORK -> PokemonErrorModel()
            else -> PokemonErrorModel()
        }
    }
}