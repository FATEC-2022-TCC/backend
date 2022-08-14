package com.fatec.tcc.animais.donos

import javax.persistence.*

@Entity(name = "donos")
data class DonoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    //@ForeignKey()
    val idUsuario: Long,
    val idAnimal: Long
)