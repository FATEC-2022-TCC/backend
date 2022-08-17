package com.fatec.tcc.animais.animal.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val type: String,
    val age: Int
)