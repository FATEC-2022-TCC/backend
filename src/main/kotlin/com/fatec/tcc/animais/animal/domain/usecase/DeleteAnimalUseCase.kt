package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import org.springframework.stereotype.Component

@Component
class DeleteAnimalUseCase(
    private val animalRepository: AnimalRepository
) {
    operator fun invoke(id: Long) {
        animalRepository.delete(id)
    }
}