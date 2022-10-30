package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.content.domain.model.Content
import org.springframework.stereotype.Component

@Component
class RemoveContentUseCase(
    private val repository: BaseRepository<Content>
) {
    operator fun invoke(id: Long) = repository.delete(id)
}