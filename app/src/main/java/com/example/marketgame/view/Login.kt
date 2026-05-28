package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R
import com.example.marketgame.databinding.ActivityLoginBinding
import com.example.marketgame.repository.ContaRepository
import com.example.marketgame.repository.SessaoRepository

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun verificacaoLogin(): Boolean {

            val email = binding.etEmail.text.toString()
            val senha = binding.etSenha.text.toString()

            val usuario = ContaRepository.contas.find {
                it.email == email && it.senha == senha
            }

            return if (usuario != null) {

                SessaoRepository.usuario = usuario

                Log.d("Usuario sessao", "$usuario")

                Toast.makeText(
                    this,
                    "Login realizado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()

                true

            } else {

                Toast.makeText(
                    this,
                    "Email ou senha inválidos",
                    Toast.LENGTH_SHORT
                ).show()

                false
            }
        }

        fun verificarCamposVazios(): Boolean {

            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            var valido = true

            if (email.isEmpty()) {
                binding.etEmail.error = "Campo obrigatório"
                binding.etEmail.requestFocus()
                valido = false
            }

            if (senha.isEmpty()) {
                binding.etSenha.error = "Campo obrigatório"
                binding.etSenha.requestFocus()
                valido = false
            }

            return valido
        }

        binding.btnLogin.setOnClickListener {

            if (!verificarCamposVazios()) {
                return@setOnClickListener
            }

            if (!verificacaoLogin()) {
                return@setOnClickListener
            }

            val intent = Intent(this, ListaJogos::class.java)
            startActivity(intent)
        }

        binding.tvCadastro.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}