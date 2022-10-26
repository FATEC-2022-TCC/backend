package com.fatec.tcc.animais.compliant.domain.model

data class NewCompliantRequest(
    val local: String,
    val description: String,
    val files: List<String>
)