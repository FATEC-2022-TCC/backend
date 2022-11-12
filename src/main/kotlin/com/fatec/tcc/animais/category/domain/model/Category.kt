package com.fatec.tcc.animais.category.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64

data class Category(
    val id: Long,
    val description: String,
    val images: List<Base64>,
    val files: List<Base64>,
)