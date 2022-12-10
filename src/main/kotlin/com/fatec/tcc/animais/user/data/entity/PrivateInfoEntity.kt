package com.fatec.tcc.animais.user.data.entity

import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "private_info")
class PrivateInfoEntity(
    val email: String,
    val telephony: String,
    val identification: String,
    val address: String,
    @Lob
    val picture: String
)