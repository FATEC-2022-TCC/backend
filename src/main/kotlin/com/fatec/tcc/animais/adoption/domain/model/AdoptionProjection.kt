package com.fatec.tcc.animais.adoption.domain.model

data class AdoptionProjection(
    val id: Long,
    val name: String,
    val description: String,
    val picture: String
)