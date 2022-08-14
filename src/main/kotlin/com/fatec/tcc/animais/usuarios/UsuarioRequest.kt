package com.fatec.tcc.animais.usuarios

data class UsuarioRequest(
        val id: Long,
        val username: String,
        val password: String,
        val email: String,
        val dataNasc: String,
        val age: Int,
)