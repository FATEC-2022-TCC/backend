package com.fatec.tcc.animais.regrasAcesso

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "regrasAcesso")
data class RegrasAcessoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val idUsuario: Long,
    val typeAccess: Long
)