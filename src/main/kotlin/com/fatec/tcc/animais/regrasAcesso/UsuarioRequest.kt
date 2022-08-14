package com.fatec.tcc.animais.regrasAcesso

data class RegrasAcessoRequest(
        val id: Long,
        val idUsuario: Long,
        val typeAcess: Long
)