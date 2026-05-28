package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R
import com.example.marketgame.databinding.ActivityMainBinding
import com.example.marketgame.model.Conta
import com.example.marketgame.repository.ContaRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        fun verificarSenhaEConfirmarSenhaIguais(senha: EditText, confirmarSenha: EditText): Boolean {
            return if (senha.text.toString() != confirmarSenha.text.toString()) {
                confirmarSenha.error = "Senhas não são iguais"
                confirmarSenha.requestFocus()

                false
            }else {
                true
            }
        }

        fun verificarCamposVazios(): Boolean {

            val campos = listOf(
                binding.etNome,
                binding.etEmail,
                binding.etTelefone,
                binding.etCpf,
                binding.etEndereco,
                binding.etCidade,
                binding.etEstado,
                binding.etSenha,
                binding.etConfirmarSenha
            )

            var valido = true

            campos.forEach { campo ->

                if (campo.text.toString().trim().isEmpty()) {

                    campo.error = "Campo obrigatório"

                    if (valido) {
                        campo.requestFocus()
                    }

                    valido = false
                }

            }

            return valido
        }

        binding.btnCadastrar.setOnClickListener {
            if (!verificarCamposVazios()) {
                return@setOnClickListener
            }

            if(!verificarSenhaEConfirmarSenhaIguais(binding.etSenha, binding.etConfirmarSenha)){
                return@setOnClickListener
            }

            val conta = Conta(
                nome = binding.etNome.text.toString(),
                email = binding.etEmail.text.toString(),
                telefone = binding.etTelefone.text.toString(),
                cpf = binding.etCpf.text.toString(),
                endereco = binding.etEndereco.text.toString(),
                cidade = binding.etCidade.text.toString(),
                estado = binding.etEstado.text.toString(),
                senha = binding.etSenha.text.toString(),
                confirmarSenha = binding.etConfirmarSenha.toString()
            )

            ContaRepository.contas.add(conta)

            Toast.makeText(
                this,
                "Usuário cadastrado com sucesso",
                Toast.LENGTH_SHORT
            ).show()


            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}