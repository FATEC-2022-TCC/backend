package com.fatec.tcc.animais.base

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

inline infix fun <T : Any, A : Any> T?.notFoundOrElse(block: T.() -> A) =
    block(this ?: throw ResponseStatusException(HttpStatus.NOT_FOUND))

inline infix fun <T : Any> T?.notFoundOrUnit(block: T.() -> Any) = notFoundOrElse {
    block()
    Unit
}

inline fun <T, A> extractAnd(
    crossinline block: T.() -> A,
    crossinline consumer: A.() -> Unit
): T.() -> Unit = {
    consumer(block())
}

fun <T> T?.notNullOrThrow(status: HttpStatus = HttpStatus.NOT_FOUND) =
    this ?: throw ResponseStatusException(status)

fun Boolean.trueOrThrow(status: HttpStatus = HttpStatus.BAD_REQUEST) {
    if (!this) throw ResponseStatusException(status)
}