package com.fatec.tcc.animais.base64.data.entity

import javax.persistence.*

@Entity
@Table(name = "base64")
class Base64Entity(
    @Id
    @GeneratedValue
    val id: Long,
    @Lob
    val data: String,
)