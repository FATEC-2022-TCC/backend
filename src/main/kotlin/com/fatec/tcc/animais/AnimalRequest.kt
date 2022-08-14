package com.fatec.tcc.animais

data class AnimalRequest(
    val id: Long,
    val especie: String,
    val age: Int
)