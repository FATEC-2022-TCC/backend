package com.fatec.tcc.animais.animal.domain.model

import java.time.Instant

data class Animal(
    val id: Long = -1,
    val picture: String,
    val name: String,
    val specie: String,
    val gender: String,
    val age: String,
    val size: String,
    val about: String,
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
)