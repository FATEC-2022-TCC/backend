package com.fatec.tcc.animais.user.domain.model

data class AdminUpdateUserPasswordRequest(
    val id: Long,
    val password: String
)