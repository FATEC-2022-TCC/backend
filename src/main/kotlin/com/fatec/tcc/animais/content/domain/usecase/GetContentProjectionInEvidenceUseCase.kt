package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class GetContentProjectionInEvidenceUseCase(
    private val contentProjectionRepository: ContentProjectionRepository
) {
    operator fun invoke() = contentProjectionRepository
        .all(Date.from(Instant.now()), "until")
}