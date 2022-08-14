package com.fatec.tcc.animais

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teste")
class Controller(
    private val animalRepository: AnimalRepository
) {

    @GetMapping("/helloworld")
    fun helloWorld() = "Hello World"

    @PostMapping("/animal")
    fun postAnimal(@RequestBody animal: Animal) = animalRepository.save(animal)
}