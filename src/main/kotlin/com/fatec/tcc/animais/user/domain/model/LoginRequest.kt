package com.fatec.tcc.animais.user.domain.model

data class LoginRequest(
    val username: String,
    val password: String
)