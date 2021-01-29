package com.rba.pokedex.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.rba.pokedex.databinding.FragmentMainBinding
import com.rba.pokedex.domain.model.PokemonModel

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(requireActivity().application)).get(
            MainViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val mainAdapter = MainAdapter(::pokemonClick)

        binding.pokemonRecyclerView.adapter = mainAdapter

        mainViewModel.pokemonList.observe(viewLifecycleOwner, {
            mainAdapter.submitList(it)
        })

        return binding.root
    }

    private fun pokemonClick(pokemonModel: PokemonModel) {
        Log.i("z- pokemon", pokemonModel.toString())
    }

}