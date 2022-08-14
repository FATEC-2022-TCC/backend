package com.fatec.tcc.animais.usuarios

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "usuarios")
data class UsuarioEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val username: String,
    val password: String,
    val email: String,
    val dataNasc: String,
    val age: Int,
)