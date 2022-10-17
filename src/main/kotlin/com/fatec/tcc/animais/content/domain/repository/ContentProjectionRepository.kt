package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.ContentProjection

interface ContentProjectionRepository {
    fun all(): List<ContentProjection>
}