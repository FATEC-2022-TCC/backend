package com.fatec.tcc.animais.animal.domain.model

import java.util.Date

data class Animal(
    val id: Long = -1,
    val name: String,
    val description: String,
    val type: String,
    val birth: Date
)