package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.UpdateContentRequest
import org.springframework.stereotype.Component

@Component
class UpdateContentUseCase(
    private val repository: BaseRepository<Content>
) {
    operator fun invoke(
        request: UpdateContentRequest
    ) = repository.find(request.id) notFoundOrElse {
        copy(
            data = request.data,
            background = request.background,
            title = request.title,
            description = request.description,
            until = request.until
        ).run(repository::update)
    }
}