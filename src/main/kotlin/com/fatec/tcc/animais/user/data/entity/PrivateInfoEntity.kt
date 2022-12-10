package com.fatec.tcc.animais.user.data.entity

import javax.persistence.*

@Entity
@Table(name = "private_info")
class PrivateInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val email: String,
    val telephony: String,
    val identification: String,
    val address: String,
    @Lob
    val picture: String
)