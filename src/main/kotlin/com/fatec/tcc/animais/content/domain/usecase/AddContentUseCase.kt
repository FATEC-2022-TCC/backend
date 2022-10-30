package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.NewContentRequest
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class AddContentUseCase(
    private val repository: BaseRepository<Content>
) {
    operator fun invoke(request: NewContentRequest) = repository.insert(
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