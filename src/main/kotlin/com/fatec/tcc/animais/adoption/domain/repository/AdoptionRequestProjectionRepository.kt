package com.fatec.tcc.animais.adoption.domain.repository

import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjection

interface AdoptionRequestProjectionRepository {
    fun getByAdoptionIdAndCreatedBy(adoptionId: Long, createdBy: String): AdoptionRequestProjection?
}