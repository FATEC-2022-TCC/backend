package com.fatec.tcc.animais.user.domain.model

data class PrivateInfo(
    val id: Long,
    val email: String,
    val telephony: String,
    val identification: String,
    val address: String,
    val picture: String
) {
    constructor() : this(-1, "", "", "", "", "")
}