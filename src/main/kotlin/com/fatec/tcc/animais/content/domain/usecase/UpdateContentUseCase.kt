package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.UpdateContentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.time.Instant
import java.util.*

@Component
class UpdateContentUseCase(
    private val repository: BaseRepository<Content>
) {
    operator fun invoke(request: UpdateContentRequest) = repository
        .find(request.id)
        ?.run {
            Content(
                request.id,
                request.data,
                request.background,
                request.title,
                request.description,
                request.until
            )
        }
        ?.run(repository::update)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}