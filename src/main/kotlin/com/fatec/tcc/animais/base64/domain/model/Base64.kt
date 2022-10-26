package com.fatec.tcc.animais.base64.domain.model

data class Base64(
    val id: Long = -1,
    val data: String
) {
    constructor(data: String) : this(-1, data)
}