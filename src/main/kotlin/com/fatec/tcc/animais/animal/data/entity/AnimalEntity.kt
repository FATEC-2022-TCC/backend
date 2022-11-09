package com.fatec.tcc.animais.animal.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val picture: String,
    val name: String,
    val specie: String,
    val gender: String,
    val age: String,
    val size: String,
    @Lob
    val about: String
) : BaseEntity()