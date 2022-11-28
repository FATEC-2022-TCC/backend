package com.fatec.tcc.animais.user.domain.model

data class UserProjection(
    val id: Long,
    val name: String,
    val username: String,
    val isActive: Boolean
)