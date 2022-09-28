package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.Result
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UpdateAnimalUseCase(
    private val animalRepository: AnimalRepository
) {
   operator fun invoke(id: Long, updateAnimalRequest: UpdateAnimalRequest): ResponseEntity<Result<Animal>>{
       val animal = animalRepository.find(id)  ?: return "Animal id not found" error ErrorCode.NOT_FOUND
       animalRepository.update(
           animal.copy(
               name = updateAnimalRequest.name,
               description = updateAnimalRequest.description,
               type = updateAnimalRequest.type,
               birth = updateAnimalRequest.birth
           )
       )
       return ResponseEntity.ok().build()
   }

}