package com.fatec.tcc.animais.adoption.domain.model

data class NewAdoptionRequest(
    val name: String,
    val description: String,
    val gender: String,
    val size: String,
    val age: String,
    val categoryId: Long,
    val picture: String,
    val images: List<String>
)