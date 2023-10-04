package com.example.livros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.livros.R
import com.example.livros.database.AppDatabase
import com.example.livros.databinding.ActivityMenuBinding
import com.example.livros.model.Livros


class MenuActivity : AppCompatActivity() {
    //Inicialização do banco de dados:

    //Inicialização do binding e ViewModel
    lateinit var binding: ActivityMenuBinding
    var titulo:String=""
    var autor:String = ""
    var ano:String = ""
    var nota:String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_projeto.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        //tenho que pegar as coisas que vao ser escritas em cada EditText



        binding.salvar.setOnClickListener {
            var titulo = binding.tituloText.text.toString()
            var autor  = binding.autorText.text.toString()
            var ano = binding.anoText.text.toString()
            var nota = binding.notaBar.rating.toString()
            //salvar um objeto livro
            val livro: Livros = Livros(titulo,autor,ano,nota)

            db.livrosDao().inserir(livro)
            finish()

        }

        binding.cancelar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
}