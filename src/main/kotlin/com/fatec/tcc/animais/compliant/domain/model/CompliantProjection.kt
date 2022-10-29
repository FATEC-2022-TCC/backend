package com.fatec.tcc.animais.compliant.domain.model

import java.util.*

data class CompliantProjection(
    val id: Long,
    val local: String,
    val description: String,
    val created: Date,
    val closed: Boolean
)