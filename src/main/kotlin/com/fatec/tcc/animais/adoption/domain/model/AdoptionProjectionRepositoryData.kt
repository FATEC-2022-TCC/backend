package com.fatec.tcc.animais.adoption.domain.model

data class AdoptionProjectionRepositoryData(
    val currentStatusCode: Int,
    val text: String,
    val gender: String,
    val size: String
)