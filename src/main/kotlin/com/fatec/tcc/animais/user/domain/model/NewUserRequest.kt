package com.fatec.tcc.animais.user.domain.model

data class NewUserRequest(
    val name: String,
    val username: String,
    val email: String,
    val password: String
)