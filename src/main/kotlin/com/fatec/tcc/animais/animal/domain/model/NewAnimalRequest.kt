package com.fatec.tcc.animais.animal.domain.model

data class NewAnimalRequest(
    val picture: String,
    val name: String,
    val categoryId: Long,
    val gender: String,
    val age: String,
    val size: String,
    val about: String
)