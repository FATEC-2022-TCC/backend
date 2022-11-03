package com.fatec.tcc.animais.status.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import java.time.Instant

data class Status(
    val id: Long = -1,
    val code: Int,
    val description: String,
    val files: ArrayList<Base64> = arrayListOf(),
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
)