package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.base.Page

data class SearchComplaintProjectionResponse(
    val page: Page<ComplaintProjection>,
    val statuses: List<ComplaintStatus>
)