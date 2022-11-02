package com.fatec.tcc.animais.complaint.domain.constant

enum class ComplaintStatuses(
    val code: Int,
    val description: String
) {
    CREATED(1, "A denúncia foi criada"),
    RUNNING(2, "A denúncia está sendo apurada"),
    CLOSED(3, "A denúncia foi fechada");

    operator fun get(index: Int) = values().let { if (index < 0 || index >= it.size) null else it[index] }
}