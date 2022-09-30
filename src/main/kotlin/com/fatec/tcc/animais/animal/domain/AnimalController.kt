package com.fatec.tcc.animais.animal.domain

import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.usecase.DeleteAnimalUseCase
import com.fatec.tcc.animais.animal.domain.usecase.UpdateAnimalUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/animal")
class AnimalController(
    private val updateAnimalUseCase: UpdateAnimalUseCase,
    private val deleteAnimalUseCase: DeleteAnimalUseCase
) {
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updateAnimalRequest: UpdateAnimalRequest) = updateAnimalUseCase(id,updateAnimalRequest)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long) = deleteAnimalUseCase(id)
}
