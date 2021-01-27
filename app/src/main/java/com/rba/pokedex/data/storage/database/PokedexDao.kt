package com.rba.pokedex.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rba.pokedex.data.storage.entity.PokemonDetailEntity
import com.rba.pokedex.data.storage.entity.PokemonEntity

@Dao
interface PokedexDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemonList: List<PokemonEntity>)

    @Query("SELECT * FROM Pokemon WHERE page = :page")
    suspend fun getPokemonByPage(page: Int): List<PokemonEntity>

    @Query("SELECT * FROM Pokemon WHERE page <= :page")
    suspend fun getAllPokemon(page: Int): List<PokemonEntity>

    @Query("SELECT * FROM detail WHERE name = :name")
    suspend fun getPokemonDetail(name: String): PokemonDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetail(pokemonDetailEntity: PokemonDetailEntity)
}
