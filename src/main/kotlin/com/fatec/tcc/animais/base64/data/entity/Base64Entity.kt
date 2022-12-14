package com.fatec.tcc.animais.base64.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "base64")
class Base64Entity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val data: String,
) : BaseEntity()