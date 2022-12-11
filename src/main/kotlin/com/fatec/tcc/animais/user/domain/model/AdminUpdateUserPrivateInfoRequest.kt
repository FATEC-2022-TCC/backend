package com.fatec.tcc.animais.user.domain.model

data class AdminUpdateUserPrivateInfoRequest(
    val email: String,
    val telephony: String,
    val identification: String,
    val address: String,
    val picture: String
)