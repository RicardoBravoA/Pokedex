package com.rba.pokedex.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
data class PokemonDetailEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponseEntity>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int
) {
    data class TypeResponseEntity(
        val slot: Int,
        val name: String
    )

}