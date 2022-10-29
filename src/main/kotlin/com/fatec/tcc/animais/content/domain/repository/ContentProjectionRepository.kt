package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import java.util.*

interface ContentProjectionRepository : SearchableRepository<ContentProjection> {
    fun until(date: Date): List<ContentProjection>
}