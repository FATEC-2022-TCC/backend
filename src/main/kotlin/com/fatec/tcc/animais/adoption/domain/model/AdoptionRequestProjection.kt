package com.fatec.tcc.animais.adoption.domain.model

data class AdoptionRequestProjection(
    val id: Long,
    val currentStatusCode: Int,
    val createdBy: String
)