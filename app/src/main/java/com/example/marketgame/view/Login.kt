package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R
import com.example.marketgame.repository.ContaRepository
import com.example.marketgame.repository.SessaoRepository

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvCadastro = findViewById<TextView>(R.id.tvCadastro)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etSenha = findViewById<EditText>(R.id.etSenha)

        fun verificacaoLogin(): Boolean {
            val email = etEmail.text.toString()
            val senha = etSenha.text.toString()

            val usuario = ContaRepository.contas.find {
                it.email == email && it.senha == senha
            }

            return if (usuario != null) {
                SessaoRepository.usuario = usuario
                Log.d("Usuario sessao", "$usuario")
                Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                true
            } else {
                Toast.makeText(this, "Email ou senha invalidos", Toast.LENGTH_SHORT).show()
                false
            }
        }


        btnLogin.setOnClickListener {
            if (!verificacaoLogin()) {
                return@setOnClickListener
            }

            val intent = Intent(this, ListaJogos::class.java)
            startActivity(intent)

        }

        tvCadastro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}