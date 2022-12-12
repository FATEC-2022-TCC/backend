package com.fatec.tcc.animais.complaint.data.entity

import java.util.Date

interface ComplaintEntityProjection {
    val id: Long
    val local: String
    val description: String
    val created: Date
    val currentStatusCode: Int
}