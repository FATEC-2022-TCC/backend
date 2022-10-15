package com.fatec.tcc.animais.user.domain.model

data class LoginResponse(
    val token: String,
    val type: String
)