package com.fatec.tcc.animais.complaint.domain.model

import java.util.*

data class ComplaintProjection(
    val id: Long,
    val local: String,
    val description: String,
    val created: Date,
    val currentStatusCode: Int
)