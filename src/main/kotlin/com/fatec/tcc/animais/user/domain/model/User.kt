package com.fatec.tcc.animais.user.domain.model

import com.fatec.tcc.animais.animal.domain.model.Animal
import java.time.Instant

data class User(
    val id: Long = -1,
    val name: String,
    val username: String,
    val password: String,
    val authority: String,
    val isActive: Boolean,
    val isValidated: Boolean,
    val privateInfo: PrivateInfo = PrivateInfo(),
    val animals: ArrayList<Animal> = arrayListOf(),
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
)