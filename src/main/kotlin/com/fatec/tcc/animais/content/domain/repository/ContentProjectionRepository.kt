package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.ContentProjection
import java.time.Instant

interface ContentProjectionRepository {
    fun until(instant: Instant): List<ContentProjection>
}