package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.stereotype.Component

@Component
class DeleteContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke(id: Long) = contentRepository.delete(id)
}