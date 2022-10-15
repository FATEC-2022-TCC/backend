package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class UpdateAnimalUseCase(
    private val animalRepository: AnimalRepository
) {
    operator fun invoke(id: Long, request: UpdateAnimalRequest): Animal {
        val animal = animalRepository.find(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return animalRepository.update(
            animal.copy(
                name = request.name,
                description = request.description,
                type = request.type,
                birth = request.birth
            )
        )
    }
}