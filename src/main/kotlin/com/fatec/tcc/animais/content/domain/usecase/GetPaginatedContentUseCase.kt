package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.stereotype.Component

@Component
class GetPaginatedContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke() = contentRepository.all()
}