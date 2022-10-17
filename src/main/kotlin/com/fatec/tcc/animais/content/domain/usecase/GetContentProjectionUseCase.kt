package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Component

@Component
class GetContentProjectionUseCase(
    private val contentProjectionRepository: ContentProjectionRepository
) {
    operator fun invoke() = contentProjectionRepository.all()
}