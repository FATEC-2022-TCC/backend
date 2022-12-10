package com.fatec.tcc.animais.complaint.domain.model

data class NewComplaintRequest(
    val local: String,
    val description: String,
    val images: List<String>
)