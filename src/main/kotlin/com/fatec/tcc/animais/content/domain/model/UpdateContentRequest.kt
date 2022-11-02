package com.fatec.tcc.animais.content.domain.model

import java.time.Instant

data class UpdateContentRequest(
    val id: Long = -1,
    val data: String,
    val background: String,
    val title: String,
    val description: String,
    val until: Instant
)