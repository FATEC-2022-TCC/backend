package com.fatec.tcc.animais.animal.domain.model

import com.fatec.tcc.animais.category.domain.model.Category
import java.time.Instant

data class Animal(
    val id: Long = -1,
    val picture: String,
    val name: String,
    val category: Category,
    val gender: String,
    val age: String,
    val size: String,
    val about: String,
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
)