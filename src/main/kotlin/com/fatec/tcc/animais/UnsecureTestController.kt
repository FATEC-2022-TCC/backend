package com.fatec.tcc.animais

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalStateException

@RestController
@RequestMapping("/test")
class UnsecureTestController(
    private val animalRepository: AnimalRepository
) {
    @GetMapping("/helloworld")
    fun helloWorld() = "Hello World"

    @PostMapping("/animal")
    fun postAnimal(@RequestBody animalRequest: AnimalRequest): AnimalEntity {
        if (animalRequest.id != -1L) {
            throw IllegalStateException("Id must be -1")
        }
        val entity = animalRequest.run {
            AnimalEntity(id, especie, age)
        }
        return animalRepository.save(entity)
    }
}