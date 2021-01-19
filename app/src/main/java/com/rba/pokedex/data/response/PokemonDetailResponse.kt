package com.rba.pokedex.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PokemonDetailResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "weight") val weight: Int,
    @field:Json(name = "base_experience") val experience: Int,
    @field:Json(name = "types") val types: List<TypeResponse>,
    val hp: Int?,
    val attack: Int?,
    val defense: Int?,
    val speed: Int?,
    val exp: Int?
) : Parcelable {

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class TypeResponse(
        @field:Json(name = "slot") val slot: Int,
        @field:Json(name = "type") val type: Type
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Type(
        @field:Json(name = "name") val name: String
    ) : Parcelable
}