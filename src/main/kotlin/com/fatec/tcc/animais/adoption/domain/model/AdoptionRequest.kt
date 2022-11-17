package com.fatec.tcc.animais.adoption.domain.model

import com.fatec.tcc.animais.status.domain.model.Status

data class AdoptionRequest(
    val id: Long,
    val statuses: ArrayList<Status>,
    val currentStatusCode: Int,
    val createdBy: String? = null
)