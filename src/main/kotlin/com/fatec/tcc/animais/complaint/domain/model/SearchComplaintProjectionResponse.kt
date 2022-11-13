package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.base.Page
import com.fatec.tcc.animais.base.StateDescription

data class SearchComplaintProjectionResponse(
    val page: Page<ComplaintProjection>,
    val statuses: List<StateDescription>
)