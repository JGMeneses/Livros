package com.example.livros.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Livros(
    @ColumnInfo(name = "Titulo") val titulo: String?,
    @ColumnInfo(name = "Autor") val autor: String?,
    @ColumnInfo(name = "Ano") val ano: String?,
    @ColumnInfo(name = "Nota") val nota: String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}