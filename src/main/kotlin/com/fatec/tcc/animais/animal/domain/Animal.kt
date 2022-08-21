package com.fatec.tcc.animais.animal.domain

data class Animal(
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val age: Int
)