package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.ContentProjection
import java.util.*

interface ContentProjectionRepository {
    fun until(date: Date): List<ContentProjection>
}