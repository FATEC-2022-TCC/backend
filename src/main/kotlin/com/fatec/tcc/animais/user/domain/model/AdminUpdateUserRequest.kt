package com.fatec.tcc.animais.user.domain.model

data class AdminUpdateUserRequest(
    val id: Long,
    val name: String,
    val authority: String,
    val isActive: Boolean,
    val privateInfo: AdminUpdateUserPrivateInfoRequest
)