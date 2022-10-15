package com.fatec.tcc.animais.user.domain.model

import com.fatec.tcc.animais.animal.domain.model.Animal

data class User(
    val id: Long = -1,
    val name: String,
    val username: String,
    val password: String,
    val email: String = "",
    val authority: String = "",
    val animals: List<Animal> = emptyList()
)