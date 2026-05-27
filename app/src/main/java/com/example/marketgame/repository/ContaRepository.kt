package com.example.marketgame.repository

import com.example.marketgame.model.Conta

object ContaRepository {
    val contas = mutableListOf(
        Conta(
            nome = "Adm",
            email = "admin@gmail.com",
            telefone = "99999-9999",
            cpf = "12345678900",
            endereco = "Rua Gamer",
            cidade = "Manaus",
            estado = "AM",
            senha = "123456",
            confirmarSenha = "123456"
        )
    )
}