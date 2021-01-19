package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonListModel(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonModel>?
) : Parcelable