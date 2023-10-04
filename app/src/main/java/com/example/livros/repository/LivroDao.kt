package com.example.livros.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.livros.model.Livros

@Dao
interface LivroDao {

    @Query("SELECT * FROM Livros")
    fun getAll(): List<Livros>

    @Insert
    fun inserir(livro: Livros): Long



}