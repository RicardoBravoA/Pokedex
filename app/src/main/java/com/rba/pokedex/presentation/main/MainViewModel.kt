package com.rba.pokedex.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rba.pokedex.data.util.Constant
import com.rba.pokedex.domain.model.PokemonModel
import com.rba.pokedex.domain.repository.PokemonListRepository
import com.rba.pokedex.domain.util.ResultType
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val pokemonListRepository: PokemonListRepository) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    val pokemonList: LiveData<List<PokemonModel>>
        get() = _pokemonList

    private val page: MutableLiveData<Int> = MutableLiveData(0)

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //try {
            when (val result = pokemonListRepository.list(page.value!!)) {
                is ResultType.Success -> {
                    _pokemonList.value = result.value.results
                    page.value!!.plus(Constant.POKEMON_LIMIT)
                }
                is ResultType.Error -> {
                    _pokemonList.value = arrayListOf()
                }
            }
            //} catch (e: Exception) {
            //    _pokemonList.value = arrayListOf()
            //}
        }
    }

}