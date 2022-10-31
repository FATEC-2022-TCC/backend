package com.fatec.tcc.animais.animal.data.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue
    val id: Long,
    @Lob
    val picture: String,
    val name: String,
    val specie: String,
    val gender: String,
    val age: String,
    val size: String,
    @Lob
    val about: String,
    val created: Date,
    val updated: Date
)