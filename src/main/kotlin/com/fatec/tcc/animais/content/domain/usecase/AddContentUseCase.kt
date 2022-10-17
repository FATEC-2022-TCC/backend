package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.NewContentRequest
import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class AddContentUseCase(
    private val contentRepository: ContentRepository
) {
    operator fun invoke(request: NewContentRequest) = contentRepository.insert(
        request.run {
            Content(
                -1,
                data,
                background,
                title,
                description,
                created = Date.from(Instant.now()),
                until
            )
        }
    )
}