package com.fatec.tcc.animais.adoption.domain.repository

import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjection

interface AdoptionRequestProjectionRepository {
    fun getByCreatedBy(createdBy: String): AdoptionRequestProjection?
}