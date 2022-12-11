package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.security.CurrentUser

@UseCase
class GetAnimalUseCase(
    private val repository: AnimalRepository
) {
    operator fun invoke(
        currentUser: CurrentUser,
        id: Long
    ) = repository.findByUserAndAnimalId(
        currentUser.id,
        id
    ).notNullOrThrow()
}