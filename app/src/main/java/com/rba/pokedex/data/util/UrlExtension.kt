package com.rba.pokedex.data.util

fun String.url(): String {
    val index = this.split("/".toRegex()).dropLast(1).last()
    return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
}