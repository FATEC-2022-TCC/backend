package com.fatec.tcc.animais.chart.model

import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection

data class ComplaintDataChart(
    val description: String,
    val color: String,
    val count: Int,
    val complaints: List<ComplaintProjection>
)