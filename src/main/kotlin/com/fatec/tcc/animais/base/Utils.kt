package com.fatec.tcc.animais.base

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

inline infix fun <T : Any, A> T?.notFoundOrElse(block: T.() -> A) =
    block(this ?: throw ResponseStatusException(HttpStatus.NOT_FOUND))

fun <T> T?.notNullOrThrow(status: HttpStatus = HttpStatus.BAD_REQUEST) =
    this ?: throw ResponseStatusException(status)

fun Boolean.trueOrThrow(status: HttpStatus = HttpStatus.BAD_REQUEST) {
    if (!this) throw ResponseStatusException(status)
}