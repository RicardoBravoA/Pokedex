package com.rba.pokedex.presentation.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rba.pokedex.data.source.list.PokemonListDataSourceFactory

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            val pokemonListRepository = PokemonListDataSourceFactory(app).create()

            return MainViewModel(
                pokemonListRepository
            ) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}