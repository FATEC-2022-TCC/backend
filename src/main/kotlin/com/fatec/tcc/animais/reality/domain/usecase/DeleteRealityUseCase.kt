package com.fatec.tcc.animais.reality.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.reality.domain.model.Reality

@UseCase
class DeleteRealityUseCase(
    private val repository: BaseRepository<Reality>
) {
    operator fun invoke(id: Long) = repository.delete(id)
}