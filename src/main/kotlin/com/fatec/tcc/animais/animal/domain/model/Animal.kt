package com.fatec.tcc.animais.animal.domain.model

import com.fatec.tcc.animais.category.domain.model.Category
import java.time.Instant

data class Animal(
    val id: Long = -1,
    val name: String,
    val description: String,
    val gender: String,
    val size: String,
    val age: String,
    val category: Category,
    val picture: String,
    val created: Instant? = null,
    val createdBy: String? = null,
    val updated: Instant? = null,
    val updatedBy: String? = null
)