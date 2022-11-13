package com.fatec.tcc.animais.category.domain.model

data class UpdateCategoryRequest(
    val id: Long = -1,
    val name: String,
    val description: String,
    val images: List<String>
)