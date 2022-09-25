package com.fatec.tcc.animais.animal.domain

import com.fatec.tcc.animais.animal.data.entity.AnimalEntityRepository
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/animal")
class AnimalController(
    private val animalEntityRepository: AnimalEntityRepository
)