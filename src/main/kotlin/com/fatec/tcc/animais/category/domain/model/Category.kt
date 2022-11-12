package com.fatec.tcc.animais.category.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64

data class Category(
    val id: Long,
    val name: String,
    val description: String,
    val images: ArrayList<Base64>,
    val files: ArrayList<Base64>,
) {
    constructor(name: String, description: String) : this(-1, name, description, arrayListOf(), arrayListOf())
}