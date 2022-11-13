package com.fatec.tcc.animais.adoption.domain.constant

import com.fatec.tcc.animais.base.StateDescription

enum class AdoptionRequestStatusEnum(
    private val code: Int,
    private val description: String
) {
    REQUESTED(0, "A adoção foi requisitada"),
    ENQUEUED(1, "A adoção foi agendada"),
    ADOPTED(2, "A adoção foi concluída"),
    CANCELED(3, "A adoção foi cancelada");

    fun toStateDescription() = StateDescription(code, description)

    companion object {
        operator fun get(index: Int) = values().let { if (index < 0 || index >= it.size) null else it[index] }
    }
}