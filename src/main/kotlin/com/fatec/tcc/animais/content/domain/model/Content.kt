package com.fatec.tcc.animais.content.domain.model

import java.util.*

data class Content(
    val id: Long = -1,
    val data: String,
    val background: String,
    val title: String,
    val description: String,
    val created: Date,
    val until: Date
)