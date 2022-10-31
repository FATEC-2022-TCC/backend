package com.fatec.tcc.animais.animal.domain.model

data class AnimalProjection(
    val id: Long,
    val picture: String,
    val name: String,
    val specie: String
)