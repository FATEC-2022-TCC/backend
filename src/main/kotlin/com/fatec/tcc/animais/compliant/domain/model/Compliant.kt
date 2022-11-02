package com.fatec.tcc.animais.compliant.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.status.domain.model.Status
import java.util.*

data class Compliant(
    val id: Long = -1,
    val local: String,
    val description: String,
    val files: List<Base64>,
    val created: Date,
    val updated: Date,
    val statuses: ArrayList<Status>
)