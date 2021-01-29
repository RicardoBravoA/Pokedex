package com.rba.pokedex.data.util

import androidx.room.TypeConverter
import com.rba.pokedex.data.storage.entity.PokemonDetailEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class EntityConverter() {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): List<PokemonDetailEntity.TypeResponseEntity>? {
        val listType =
            Types.newParameterizedType(
                List::class.java,
                PokemonDetailEntity.TypeResponseEntity::class.java
            )
        val adapter: JsonAdapter<List<PokemonDetailEntity.TypeResponseEntity>> =
            moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: List<PokemonDetailEntity.TypeResponseEntity>?): String {
        val listType =
            Types.newParameterizedType(
                List::class.java,
                PokemonDetailEntity.TypeResponseEntity::class.java
            )
        val adapter: JsonAdapter<List<PokemonDetailEntity.TypeResponseEntity>> =
            moshi.adapter(listType)
        return adapter.toJson(type)
    }
}