package com.fatec.tcc.animais.animal.domain

import java.util.Date

data class Animal(
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val dataNascimento: Date
)