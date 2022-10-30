package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.UpdateContentRequest
import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class UpdateContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke(request: UpdateContentRequest) = contentRepository
        .find(request.id)
        ?.run {
            Content(
                request.id,
                request.data,
                request.background,
                request.title,
                request.description,
                created,
                request.until
            )
        }
        ?.run(contentRepository::update)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}