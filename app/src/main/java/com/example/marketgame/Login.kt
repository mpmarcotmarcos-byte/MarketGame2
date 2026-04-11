package com.example.marketgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        fun verificacaoLogin() {
            val email = etEmail.text.toString()
            val senha = etSenha.text.toString()

            if (email == "teste@gmail.com" && senha == "123") {
                Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email ou senha invalidos", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener {
            verificacaoLogin()
        }

        tvCadastro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}