package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.status.domain.model.Status

class UpdateComplaintRequest(
    val id: Long,
    val status: Status
)