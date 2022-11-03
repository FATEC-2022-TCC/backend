package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.status.domain.model.NewStatusRequest

class UpdateComplaintRequest(
    val id: Long,
    val status: NewStatusRequest
)