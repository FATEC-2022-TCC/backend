package com.fatec.tcc.animais.base64.domain.model

import java.time.Instant

data class Base64(
    val id: Long = -1,
    val data: String,
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
) {
    constructor(data: String) : this(-1, data)
}