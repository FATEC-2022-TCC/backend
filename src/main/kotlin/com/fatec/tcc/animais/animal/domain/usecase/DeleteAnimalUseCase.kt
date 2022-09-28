package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import org.springframework.http.ResponseEntity
import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.Result
import org.springframework.stereotype.Component

@Component
class DeleteAnimalUseCase(
    private val animalRepository: AnimalRepository
){
    operator fun invoke(id: Long):ResponseEntity<Result<Unit>>{
        try {
            animalRepository.delete(id)
        }catch (exception: Exception){
            return "Animal id not found" error ErrorCode.NOT_FOUND
        }
        return ResponseEntity.ok().build()
    }
}