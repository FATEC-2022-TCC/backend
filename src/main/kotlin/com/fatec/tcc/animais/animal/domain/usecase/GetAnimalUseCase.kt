package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notNullOrThrow
import org.springframework.stereotype.Component

@Component
class GetAnimalUseCase(
    private val repository: BaseRepository<Animal>
) {
    operator fun invoke(id: Long) = repository.find(id).notNullOrThrow()
}