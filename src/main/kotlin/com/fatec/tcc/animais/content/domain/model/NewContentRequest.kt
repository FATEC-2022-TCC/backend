package com.fatec.tcc.animais.content.domain.model

import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class NewContentRequest(
    val data: String,
    val background: String,
    val title: String,
    val description: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val until: Date
)