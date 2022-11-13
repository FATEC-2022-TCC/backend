package com.fatec.tcc.animais.adoption.domain.constant

import com.fatec.tcc.animais.base.StateDescription

enum class AdoptionStatusEnum(
    val code: Int,
    val description: String
) {
    CREATED(0, "O animal foi inserido no sistema, mas ainda não"),
    INVISIBLE(1, "O animal não aparecerá aos usuários"),
    VISIBLE(2, "O animal aparecerá aos usuários"),
    ADOPTED(3, "A denúncia foi resolvida"),
    IMPOSSIBLE(4, "Por algum motivo o animal não pode mais ser adotado");

    fun toStateDescription() = StateDescription(code, description)
}