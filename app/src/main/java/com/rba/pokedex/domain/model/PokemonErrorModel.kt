package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonErrorModel(
    val code: Int,
    val message: String?
) : Parcelable