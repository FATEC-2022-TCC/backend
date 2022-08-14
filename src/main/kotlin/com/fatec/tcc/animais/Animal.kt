package com.fatec.tcc.animais

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val especie: String,
    val age: Int
)