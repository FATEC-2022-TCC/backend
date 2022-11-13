package com.fatec.tcc.animais.adoption.domain.model

data class NewAdoptionRequest(
    val name: String,
    val description: String,
    val picture: String,
    val images: List<String>
)