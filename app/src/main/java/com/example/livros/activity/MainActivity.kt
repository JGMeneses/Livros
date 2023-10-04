package com.example.livros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livros.R
import com.example.livros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.cadastrar.setOnClickListener {
            val i  = Intent(this, MenuActivity::class.java)
            startActivity(i)
        }

        binding.listar.setOnClickListener {
            val i = Intent(this, ListaActivity::class.java)
            startActivity(i)
        }
    }
}