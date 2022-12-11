package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.security.CurrentUser

@UseCase
class DeleteAnimalUseCase(
    private val repository: BaseRepository<Animal>,
    private val animalRepository: AnimalRepository
) {
    operator fun invoke(
        currentUser: CurrentUser,
        id: Long
    ) = animalRepository.findByUserAndAnimalId(currentUser.id, id) notFoundOrUnit {
        repository.delete(id)
    }
}