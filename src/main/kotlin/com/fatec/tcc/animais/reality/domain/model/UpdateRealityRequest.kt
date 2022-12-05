package com.fatec.tcc.animais.reality.domain.model

data class UpdateRealityRequest(
    val id: Long,
    val data: String,
    val scale: Float,
    val title: String,
    val description: String,
    val background: String,
    val isVisible: Boolean,
    val images: List<String>
)