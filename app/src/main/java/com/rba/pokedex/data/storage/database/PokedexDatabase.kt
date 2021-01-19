package com.rba.pokedex.data.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rba.pokedex.data.storage.entity.PokemonDetailEntity
import com.rba.pokedex.data.storage.entity.PokemonEntity

@Database(entities = [PokemonEntity::class, PokemonDetailEntity::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokedexDao(): PokedexDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: PokedexDatabase

        fun getDatabase(context: Context): PokedexDatabase {
            synchronized(PokedexDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PokedexDatabase::class.java,
                        "pokedex-database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}