package com.fatec.tcc.animais.status.domain.model

data class NewStatusRequest(
    val code: Int,
    val description: String,
    val files: ArrayList<String>,
)