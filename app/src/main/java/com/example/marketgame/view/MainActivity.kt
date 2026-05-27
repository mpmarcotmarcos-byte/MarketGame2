package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
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

        fun verificacaoCamposFormularioObrigatorio(campo: EditText): Boolean {

            return if (campo.text.toString().trim().isEmpty()) {

                campo.error = "Campo obrigatório"
                campo.requestFocus()

                false
            } else {
                true
            }
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

        binding.btnCadastrar.setOnClickListener {
            if (!verificacaoCamposFormularioObrigatorio(binding.etNome))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etEmail))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etTelefone))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etCpf))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etEndereco))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etCidade))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etEstado))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etSenha))
                return@setOnClickListener

            if (!verificacaoCamposFormularioObrigatorio(binding.etConfirmarSenha))
                return@setOnClickListener

            if(!verificarSenhaEConfirmarSenhaIguais(binding.etSenha, binding.etConfirmarSenha))
                return@setOnClickListener

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

            Log.d("Log cadastrar informações", "$conta")

            ContaRepository.contas.add(conta)
        }
    }
}