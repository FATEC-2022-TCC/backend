package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.Animal
import com.fatec.tcc.animais.roles.domain.Role

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val roles: List<Role>,
    val animals: List<Animal>
)