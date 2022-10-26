package com.fatec.tcc.animais.compliant.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import java.util.Date

data class Compliant(
    val id: Long = -1,
    val local: String,
    val description: String,
    val created: Date,
    val files: List<Base64>
)