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
    val stats: List<Stats>
) {
    data class TypeResponse(
        val slot: Int,
        val type: Type
    )

    data class Type(
        val name: String
    )

    data class Stats(
        val baseStat: Int,
        val stat: Stat
    )

    data class Stat(
        val name: String
    )

}