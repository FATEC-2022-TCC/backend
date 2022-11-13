package com.fatec.tcc.animais.category.domain.model

data class AddCategoryRequest(
    val name: String,
    val description: String,
    val images: List<String>
)