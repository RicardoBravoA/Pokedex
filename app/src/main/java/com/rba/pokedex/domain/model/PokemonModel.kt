package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonModel(
    var page: Int = 0,
    val name: String,
    val url: String
) : Parcelable