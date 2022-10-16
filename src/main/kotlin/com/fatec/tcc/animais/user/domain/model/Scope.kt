package com.fatec.tcc.animais.user.domain.model

enum class Scope(
    private val scope: String
) {
    ADMIN("ADMIN"),
    NORMAL("NORMAL");

    override fun toString() = scope
}