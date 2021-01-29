package com.rba.pokedex.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String
) : Parcelable