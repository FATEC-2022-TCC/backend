package com.fatec.tcc.animais.compliant.data.entity

import java.util.Date

interface CompliantProjectionEntity {
    val id: Long
    val local: String
    val description: String
    val created: Date
}