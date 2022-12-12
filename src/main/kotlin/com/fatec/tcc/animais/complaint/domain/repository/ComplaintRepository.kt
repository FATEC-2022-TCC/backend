package com.fatec.tcc.animais.complaint.domain.repository

import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection

interface ComplaintRepository {
    fun search(
        statuses: List<Int>
    ): List<ComplaintProjection>
}