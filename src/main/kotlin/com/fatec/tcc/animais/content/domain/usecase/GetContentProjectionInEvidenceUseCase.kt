package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import java.time.Instant

@UseCase
class GetContentProjectionInEvidenceUseCase(
    private val contentProjectionRepository: ContentProjectionRepository
) {
    operator fun invoke() = contentProjectionRepository.until(Instant.now())
}