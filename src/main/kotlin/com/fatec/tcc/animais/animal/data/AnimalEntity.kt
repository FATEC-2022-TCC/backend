package com.fatec.tcc.animais.animal.data

import javax.persistence.*

@Entity
@Table(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val age: Int
)