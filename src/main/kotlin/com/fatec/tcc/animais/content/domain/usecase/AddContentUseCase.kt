package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.stereotype.Component

@Component
class AddContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke(content: Content) = contentRepository.insert(content)
}