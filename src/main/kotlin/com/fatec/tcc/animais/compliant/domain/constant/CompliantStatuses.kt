package com.fatec.tcc.animais.compliant.domain.constant

enum class CompliantStatuses(
    val code: Int,
    val description: String
) {
    CREATED(1, "A denúncia foi criada"),
    RUNNING(2, "A denúncia está sendo apurada"),
    CLOSED(3, "A denúncia foi fechada");

    private val values = values()

    operator fun get(index: Int) = if (index < 0 || index >= values.size) null else values[index]
}