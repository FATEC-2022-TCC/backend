package com.fatec.tcc.animais.user.domain.model

data class UpdateUserPasswordRequest(
    val id: Long,
    val password: String
)