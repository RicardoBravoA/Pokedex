package com.rba.pokedex.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "page") var page: Int = 0,
    @ColumnInfo(name = "url") val url: String
)