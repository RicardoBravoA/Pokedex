package com.rba.pokedex.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon-detail")
data class PokemonDetailEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponse>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val exp: Int
) {
    data class TypeResponse(
        val slot: Int,
        val type: Type
    )

    data class Type(
        val name: String
    )

}