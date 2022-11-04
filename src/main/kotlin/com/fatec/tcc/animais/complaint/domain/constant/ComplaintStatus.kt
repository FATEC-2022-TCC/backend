package com.fatec.tcc.animais.complaint.domain.constant

enum class ComplaintStatus(
    val code: Int,
    val description: String
) {
    CREATED(1, "A denúncia foi criada"),
    RUNNING(2, "A denúncia está sendo apurada"),
    PAUSED(3, "A denúncia está sendo apurada"),
    RESOLVED(4, "A denúncia foi resolvida");

    operator fun get(index: Int) = values().let { if (index < 0 || index >= it.size) null else it[index] }
}