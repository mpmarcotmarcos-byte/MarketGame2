package com.example.marketgame

import ProdutoAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Produto

class ListaProdutos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        val recycler = findViewById<RecyclerView>(R.id.recyclerProdutos)

        val listaProdutos = listOf(
            Produto("Arroz", 25.0, R.drawable.produto01, 4.5f),
            Produto("Feijão", 10.0, R.drawable.produto05, avaliacao = 3.5f),
            Produto("Macarrão", 5.5, R.drawable.produto03, avaliacao = 4.0f),
            Produto("Carne", 45.0, R.drawable.produto04, avaliacao = 5.0f)
        )

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ProdutoAdapter(listaProdutos)
    }
}