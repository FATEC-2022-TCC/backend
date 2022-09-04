package com.fatec.tcc.animais.base

enum class ErrorCode(
    val code: Long
) {
    INVALID_LOGIC(1 shl 0),
    ALREADY_EXISTS(1 shl 1),
    NOT_FOUND(1 shl 2);
}