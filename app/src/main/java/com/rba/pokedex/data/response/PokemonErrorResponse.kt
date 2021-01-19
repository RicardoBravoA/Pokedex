package com.rba.pokedex.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonErrorResponse(
    val code: Int,
    val message: String?
) : Parcelable
