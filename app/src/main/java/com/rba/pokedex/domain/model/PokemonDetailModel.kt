package com.rba.pokedex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonDetailModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeModel>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
) : Parcelable {

    @Parcelize
    data class TypeModel(
        val slot: Int,
        val type: TypeItem
    ) : Parcelable

    @Parcelize
    data class TypeItem(
        val name: String
    ) : Parcelable

}