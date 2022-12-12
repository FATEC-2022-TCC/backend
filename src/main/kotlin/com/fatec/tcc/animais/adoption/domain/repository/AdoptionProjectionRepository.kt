package com.fatec.tcc.animais.adoption.domain.repository

import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.base.Page

interface AdoptionProjectionRepository {
    fun search(
        text: String,
        gender: String,
        size: String,
        statuses: List<Int>,
        page: Int,
        counter: Int,
    ): Page<AdoptionProjection>

    fun search(
        createdBy: String,
        text: String,
        page: Int,
        size: Int
    ): Page<AdoptionProjection>
}