package com.fatec.tcc.animais.content.domain.model

import java.util.*

data class NewContentRequest(
    val data: String,
    val background: String,
    val title: String,
    val description: String,
    val until: Date
)