package com.example.livros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livros.model.Livros
import com.example.livros.repository.LivroDao

@Database(entities = [Livros::class], version = 2)
abstract  class AppDatabase: RoomDatabase() {
    abstract fun livrosDao(): LivroDao
}