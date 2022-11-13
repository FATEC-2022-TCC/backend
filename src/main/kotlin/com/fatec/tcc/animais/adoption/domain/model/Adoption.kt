package com.fatec.tcc.animais.adoption.domain.model

import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.status.domain.model.Status

data class Adoption(
    val id: Long,
    val name: String,
    val description: String,
    val picture: String,
    val images: ArrayList<Base64>,
    val statuses: ArrayList<Status>,
    val currentStatusCode: Int,
    val requests: ArrayList<AdoptionRequest>
)