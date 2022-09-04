package com.fatec.tcc.animais.base

import org.springframework.http.ResponseEntity

sealed interface Result<T> {
    data class Success<T>(
        val data: T
    ) : Result<T>

    data class Error<T>(
        val message: String,
        val code: Long
    ) : Result<T>

    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> error(message: String, errorCode: ErrorCode) = Error<T>(message, errorCode.code)
    }
}

fun <T> T?.trySuccess() = this?.success() ?: ResponseEntity.notFound().build()
fun <T> T.success(): ResponseEntity<Result<T>> = ResponseEntity.ok(Result.success(this))
infix fun <T> String.error(errorCode: ErrorCode): ResponseEntity<Result<T>> =
    ResponseEntity.badRequest().body(Result.error(this, errorCode))