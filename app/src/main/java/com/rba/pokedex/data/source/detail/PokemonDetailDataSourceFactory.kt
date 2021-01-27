package com.rba.pokedex.data.source.detail

import android.content.Context
import com.rba.pokedex.data.storage.database.PokedexDatabase
import com.rba.pokedex.data.util.NetworkPreference
import com.rba.pokedex.data.util.isInternet
import com.rba.pokedex.domain.repository.PokemonDetailRepository

class PokemonDetailDataSourceFactory(private val context: Context) {

    fun create(): PokemonDetailRepository {
        val database = PokedexDatabase.getDatabase(context)
        val value = if (context.isInternet()) NetworkPreference.CLOUD else NetworkPreference.DB

        return if (NetworkPreference.CLOUD == value) {
            PokemonDetailRemoteDataSource(database.pokedexDao())
        } else {
            PokemonDetailLocalDataSource(database.pokedexDao())
        }
    }

}