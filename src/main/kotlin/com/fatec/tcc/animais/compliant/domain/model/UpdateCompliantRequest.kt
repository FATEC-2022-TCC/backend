package com.fatec.tcc.animais.compliant.domain.model

import com.fatec.tcc.animais.status.domain.model.Status

class UpdateCompliantRequest(
    val id: Long,
    val status: Status
)