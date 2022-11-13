package com.fatec.tcc.animais.complaint.domain.constant

import com.fatec.tcc.animais.base.StateDescription

enum class ComplaintStatusEnum(
    val code: Int,
    val description: String
) {
    CREATED(0, "A denúncia foi criada"),
    RUNNING(1, "A denúncia está sendo apurada"),
    PAUSED(2, "A denúncia está pausada"),
    RESOLVED(3, "A denúncia foi resolvida"),
    CANCEL(4, "A denúncia foi cancelada");

    fun toStateDescription() = StateDescription(code, description)

    companion object {
        operator fun get(index: Int) = values().let { if (index < 0 || index >= it.size) null else it[index] }
    }
}