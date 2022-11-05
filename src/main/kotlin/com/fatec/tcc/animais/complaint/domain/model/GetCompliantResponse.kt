package com.fatec.tcc.animais.complaint.domain.model

data class GetCompliantResponse(
    val complaint: Complaint,
    val allowedStatus: List<ComplaintStatus>
)