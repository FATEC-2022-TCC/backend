package com.fatec.tcc.animais.reality.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64

data class Reality(
    val id: Long,
    val data: String,
    val scale: Float,
    val title: String,
    val description: String,
    val images: ArrayList<Base64>
)