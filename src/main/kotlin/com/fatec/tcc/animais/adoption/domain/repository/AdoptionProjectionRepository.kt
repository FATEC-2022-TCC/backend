package com.fatec.tcc.animais.adoption.domain.repository

import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.base.Page

interface AdoptionProjectionRepository {
    fun searchProjection(
        text: String,
        gender: String,
        size: String,
        statuses: List<Int>,
        page: Int,
        counter: Int,
    ): Page<AdoptionProjection>

    fun projectAllByCreatedByRequest(
        createdBy: String,
        text: String,
        page: Int,
        size: Int
    ): Page<AdoptionProjection>
}