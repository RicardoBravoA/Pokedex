package com.rba.pokedex.data.storage.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "pokemon")
@Parcelize
data class PokemonEntity(
    @PrimaryKey val name: String,
    var page: Int = 0,
    val url: String
) : Parcelable