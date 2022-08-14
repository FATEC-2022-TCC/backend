package com.fatec.tcc.animais.donos

data class DonoRequest(
        val id: Long,
        val idUsuario: Long,
        val idAnimal: Long
)