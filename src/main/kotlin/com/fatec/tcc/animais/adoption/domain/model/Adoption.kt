package com.fatec.tcc.animais.adoption.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.category.domain.model.Category
import com.fatec.tcc.animais.status.domain.model.Status
import java.time.Instant

data class Adoption(
    val id: Long,
    val name: String,
    val description: String,
    val gender: String,
    val size: String,
    val category: Category,
    val picture: String,
    val images: ArrayList<Base64>,
    val statuses: ArrayList<Status>,
    val currentStatusCode: Int,
    val requests: ArrayList<AdoptionRequest>,
    val created: Instant? = null
)