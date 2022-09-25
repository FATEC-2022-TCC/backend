package com.fatec.tcc.animais.user.domain.model

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.roles.domain.Role

data class User(
    val id: Long = -1,
    val name: String,
    val username: String,
    val password: String,
    val email: String = "",
    val roles: List<Role> = emptyList(),
    val animals: List<Animal> = emptyList()
)