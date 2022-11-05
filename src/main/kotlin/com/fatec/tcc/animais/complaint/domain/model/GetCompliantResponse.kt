package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatus

data class GetCompliantResponse(
    val complaint: Complaint,
    val allowedStatus: Set<ComplaintStatus>
)