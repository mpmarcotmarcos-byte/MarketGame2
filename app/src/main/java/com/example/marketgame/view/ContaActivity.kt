package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R

class ContaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSairDaConta = findViewById<TextView>(R.id.btnSairDaConta)
        val btnVoltar = findViewById<TextView>(R.id.btnVoltar)

        btnSairDaConta.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            val intent = Intent(this, ListaJogos::class.java)
            startActivity(intent)
        }
    }
}