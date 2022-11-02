package com.fatec.tcc.animais.user.domain.model

data class UserProjection(
    val id: Long,
    val username: String
) {
    constructor(id: Long) : this(id, "")
}