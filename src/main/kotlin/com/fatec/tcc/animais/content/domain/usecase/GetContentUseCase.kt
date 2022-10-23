package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class GetContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke(id: Long) =
        contentRepository.get(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}