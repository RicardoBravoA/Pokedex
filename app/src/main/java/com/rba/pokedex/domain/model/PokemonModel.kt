package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonModel(
    val name: String,
    var page: Int = 0,
    val url: String
) : Parcelable