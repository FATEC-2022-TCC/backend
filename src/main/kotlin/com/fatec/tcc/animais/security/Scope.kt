package com.fatec.tcc.animais.security

enum class Scope(
    private val scope: String
) {
    ADMIN("ADMIN"),
    NORMAL("NORMAL");

    override fun toString() = scope
}