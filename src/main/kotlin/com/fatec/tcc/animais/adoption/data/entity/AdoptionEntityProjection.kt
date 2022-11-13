package com.fatec.tcc.animais.adoption.data.entity

interface AdoptionEntityProjection {
    val id: Long
    val name: String
    val description: String
    val picture: String
}