package com.fatec.tcc.animais.animal.domain.model

data class UpdateAnimalRequest(
    val id: Long,
    val picture: String,
    val name: String,
    val categoryId: Long,
    val gender: String,
    val age: String,
    val size: String,
    val description: String
)