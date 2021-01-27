package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonErrorModel(
    val code: Int = 0,
    val message: String? = "An error occurred"
) : Parcelable