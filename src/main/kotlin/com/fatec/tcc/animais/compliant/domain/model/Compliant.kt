package com.fatec.tcc.animais.compliant.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import java.util.*

data class Compliant(
    val id: Long = -1,
    val local: String,
    val description: String,
    val created: Date,
    val files: List<Base64>,
    val resolution: String,
    val resolutionFiles: List<Base64>,
    val closed: Boolean,
    val updated: Date
)