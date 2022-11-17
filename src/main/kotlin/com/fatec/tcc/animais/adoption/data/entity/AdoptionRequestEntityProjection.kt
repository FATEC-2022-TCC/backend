package com.fatec.tcc.animais.adoption.data.entity

interface AdoptionRequestEntityProjection {
    val id: Long
    val currentStatusCode: Int
    val createdBy: String
}