package com.rba.pokedex.data.source.list

import android.content.Context
import com.rba.pokedex.data.storage.database.PokedexDatabase
import com.rba.pokedex.data.util.NetworkPreference.CLOUD
import com.rba.pokedex.data.util.NetworkPreference.DB
import com.rba.pokedex.data.util.isInternet
import com.rba.pokedex.domain.repository.PokemonListRepository

class PokemonListDataSourceFactory(private val context: Context) {

    fun create(): PokemonListRepository {
        val database = PokedexDatabase.getDatabase(context)
        val value = if (context.isInternet()) CLOUD else DB

        return if (CLOUD == value) {
            PokemonListRemoteDataSource(database.pokedexDao())
        } else {
            PokemonListLocalDataSource(database.pokedexDao())
        }
    }

}