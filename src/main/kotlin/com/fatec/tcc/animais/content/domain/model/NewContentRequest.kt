package com.fatec.tcc.animais.content.domain.model

import java.time.Instant

data class NewContentRequest(
    val data: String,
    val background: String,
    val title: String,
    val description: String,
    val until: Instant
)