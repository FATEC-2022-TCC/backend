package com.fatec.tcc.animais.animal.domain.model

import java.util.*

data class Animal(
    val id: Long = -1,
    val picture: String,
    val name: String,
    val specie: String,
    val gender: String,
    val age: String,
    val size: String,
    val about: String,
    val created: Date,
    val updated: Date
)