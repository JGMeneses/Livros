package com.example.livros.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.livros.R
import com.example.livros.database.AppDatabase
import com.example.livros.databinding.ActivityListaBinding
import com.example.livros.model.Livros

import android.util.Log

class ListaActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaBinding
    private var currentIndex = 0
    lateinit var listaLivros: List<Livros>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lista)

        // Listar livros
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_projeto.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()
        listaLivros = db.livrosDao().getAll()
       //Log.i("LISTAR",listaLivros[0].titulo)
        if (listaLivros.isNotEmpty()) {
            exibirDetalhesDoLivro(currentIndex)
        }

        binding.proximo.setOnClickListener {
            // Avance para o próximo livro (se houver)
            if (currentIndex < listaLivros.size - 1) {
                currentIndex++
                exibirDetalhesDoLivro(currentIndex)
            }
        }

        binding.anterior.setOnClickListener {
            // Retroceda para o livro anterior (se houver)
            if (currentIndex > 0) {
                currentIndex--
                exibirDetalhesDoLivro(currentIndex)
            }
        }
    }

    private fun exibirDetalhesDoLivro(index: Int) {

        binding.textView5.text= listaLivros[index].titulo
        binding.textView6.text =  listaLivros[index].autor
        binding.textView7.text =    listaLivros[index].ano
        binding.textView8.text =   listaLivros[index].nota
    }
}
