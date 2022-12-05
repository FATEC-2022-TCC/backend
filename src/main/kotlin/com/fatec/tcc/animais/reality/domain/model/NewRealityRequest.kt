package com.fatec.tcc.animais.reality.domain.model

data class NewRealityRequest(
    val data: String,
    val scale: Float,
    val title: String,
    val description: String,
    val background: String,
    val images: List<String>
)