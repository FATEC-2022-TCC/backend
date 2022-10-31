package com.fatec.tcc.animais.compliant.domain.model

class UpdateCompliantRequest(
    val id: Long,
    val resolution: String,
    val resolutionFiles: List<String>,
    val closed: Boolean
)