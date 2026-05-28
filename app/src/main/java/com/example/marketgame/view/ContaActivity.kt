package com.example.marketgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marketgame.R
import com.example.marketgame.databinding.ActivityContaBinding
import com.example.marketgame.repository.SessaoRepository

class ContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = SessaoRepository.usuario

        binding.tvUsuarioNome.text = usuario?.nome ?: "Desconhecido"
        binding.tvEmailVisualizar.text = "Email: " + (usuario?.email ?: "Email não cadastrado")
        binding.tvTelefoneVisualizar.text = "Telefone: " + (usuario?.telefone ?: "Telefone não cadastrado")
        binding.tvCpfVisualizar.text = "CPF: " + (usuario?.cpf ?: "CPF não cadastrado")
        binding.tvEnderecoVisualizar.text = "Endereço: " + (usuario?.endereco ?: "Endereço não cadastrado")
        binding.tvCidadeVisualizar.text = "Cidade: " + (usuario?.cidade ?: "Cidade não cadastrado")
        binding.tvEstadoVisualizar.text = "Estado: " + (usuario?.estado ?: "Estado não encontrado")

        binding.btnSairDaConta.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, ListaJogos::class.java)
            startActivity(intent)
        }
    }
}