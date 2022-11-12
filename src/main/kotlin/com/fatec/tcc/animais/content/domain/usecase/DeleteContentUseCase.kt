package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.content.domain.model.Content

@UseCase
class DeleteContentUseCase(
    private val repository: BaseRepository<Content>
) {
    operator fun invoke(id: Long) = repository.delete(id)
}