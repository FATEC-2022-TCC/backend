package com.fatec.tcc.animais.complaint.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.status.domain.model.Status
import java.time.Instant

data class Complaint(
    val id: Long = -1,
    val local: String,
    val description: String,
    val files: List<Base64>,
    val statuses: ArrayList<Status>,
    val created: Instant,
    val updated: Instant,
)