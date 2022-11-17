package com.fatec.tcc.animais.adoption.domain.model

import com.fatec.tcc.animais.status.domain.model.NewStatusRequest

data class UpdateAdoptionRequestRequest(
    val id: Long,
    val status: NewStatusRequest
)