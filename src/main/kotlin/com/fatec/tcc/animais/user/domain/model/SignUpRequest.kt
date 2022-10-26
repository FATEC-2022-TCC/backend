package com.fatec.tcc.animais.user.domain.model

data class SignUpRequest(
    val name: String,
    val username: String,
    val email: String,
    val password: String
)