package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R

class ListaJogos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_jogos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listaJogos)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val conta = findViewById<TextView>(R.id.btnContaMenu);

        conta.setOnClickListener {
            val intent = Intent(this, ContaActivity::class.java)
            startActivity(intent);
        }
    }


}