package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.ContentProjection
import java.util.Date

interface ContentProjectionRepository {
    fun all(): List<ContentProjection>
    fun all(date: Date, vararg sorts: String): List<ContentProjection>
}