package com.fatec.tcc.animais.user.domain.model

data class UpdateUserRequest(
    val id: Long,
    val name: String,
    val email: String,
    val authority: String,
    val isActive: Boolean,
    val isValidated: Boolean,
    val privateInfo: UpdateUserPrivateInfoRequest
)