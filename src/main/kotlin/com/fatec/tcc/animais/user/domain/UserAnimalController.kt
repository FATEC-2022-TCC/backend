package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.usecase.*
import com.fatec.tcc.animais.security.toCurrentUser
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user/animal")
class UserAnimalController(
    private val addAnimalUseCase: AddAnimalUseCase,
    private val getAnimalUseCase: GetAnimalUseCase,
    private val getAnimalProjectionUseCase: GetAnimalProjectionUseCase,
    private val updateAnimalUseCase: UpdateAnimalUseCase,
    private val deleteAnimalUseCase: DeleteAnimalUseCase
) {
    @PostMapping
    fun post(
        authentication: Authentication,
        @RequestBody request: NewAnimalRequest
    ) = addAnimalUseCase(
        authentication.toCurrentUser(),
        request
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getAnimalUseCase(id)

    @GetMapping("/projection")
    fun projection(
        authentication: Authentication,
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = getAnimalProjectionUseCase(
        authentication.toCurrentUser(),
        text,
        page - 1
    )

    @PutMapping
    fun put(
        @RequestBody request: UpdateAnimalRequest
    ) = updateAnimalUseCase(request)

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ) = deleteAnimalUseCase(id)
}