package com.fatec.tcc.animais.content.domain.model

data class ContentProjection(
    val id: Long,
    val title: String,
    val description: String,
    val background: String
)