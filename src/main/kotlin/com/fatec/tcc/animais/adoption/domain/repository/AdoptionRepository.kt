package com.fatec.tcc.animais.adoption.domain.repository

import com.fatec.tcc.animais.adoption.domain.model.Adoption

interface AdoptionRepository {
    fun findByCreatedByAndId(
        id: Long,
        createdBy: String
    ): Adoption?
}