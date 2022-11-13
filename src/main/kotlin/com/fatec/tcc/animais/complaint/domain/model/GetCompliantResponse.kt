package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.base.StateDescription

data class GetCompliantResponse(
    val complaint: Complaint,
    val allowedStatus: List<StateDescription>
)