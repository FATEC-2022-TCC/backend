package com.fatec.tcc.animais.animal.domain.model

data class UpdateAnimalRequest(
    val id: Long,
    val picture: String,
    val name: String,
    val specie: String,
    val gender: String,
    val age: String,
    val size: String,
    val about: String
)