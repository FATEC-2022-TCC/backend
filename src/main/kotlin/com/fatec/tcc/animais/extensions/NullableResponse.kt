package com.fatec.tcc.animais.extensions

import org.springframework.http.ResponseEntity

fun <T> T?.asResponse() =
    if (this == null) {
        ResponseEntity.notFound().build()
    } else {
        ResponseEntity.ok(this)
    }