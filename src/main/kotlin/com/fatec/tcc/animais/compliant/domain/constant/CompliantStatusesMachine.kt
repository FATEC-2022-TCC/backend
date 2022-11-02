package com.fatec.tcc.animais.compliant.domain.constant

object CompliantStatusesMachine {
    private val rules = hashMapOf(
        1 to 2,
        2 to 3
    )

    fun canGo(from: Int, to: Int) = rules[from] == to
}