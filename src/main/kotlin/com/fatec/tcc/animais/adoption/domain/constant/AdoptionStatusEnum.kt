package com.fatec.tcc.animais.adoption.domain.constant

import com.fatec.tcc.animais.base.StateDescription

enum class AdoptionStatusEnum(
    val code: Int,
    val description: String
) {
    CREATED(0, "O animal foi inserido no sistema, mas não está visível aos usuários"),
    INVISIBLE(1, "O animal não está visível aos usuários"),
    VISIBLE(2, "O animal está visível aos usuários"),
    ADOPTED(3, "O animal foi adotado"),
    IMPOSSIBLE(4, "O animal não pode mais ser adotado");

    fun toStateDescription() = StateDescription(code, description)
}