package com.fatec.tcc.animais.user.domain.model

data class SignInResponse(
    val token: String,
    val type: String
)