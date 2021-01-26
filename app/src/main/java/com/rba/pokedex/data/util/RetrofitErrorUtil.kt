package com.rba.pokedex.data.util

import com.rba.pokedex.data.network.ApiManager
import com.rba.pokedex.data.response.PokemonErrorResponse
import retrofit2.Response
import java.io.IOException

object RetrofitErrorUtil {
    fun parseError(response: Response<*>): PokemonErrorResponse? {

        val converter = ApiManager.retrofit.responseBodyConverter<PokemonErrorResponse>(
            PokemonErrorResponse::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: PokemonErrorResponse

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return PokemonErrorResponse(0, "An error occurred")
        }

        return error
    }
}