package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.animal.domain.usecase.AddAnimalUseCase
import com.fatec.tcc.animais.animal.domain.usecase.GetAnimalProjectionUseCase
import com.fatec.tcc.animais.security.toCurrentUser
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val addAnimalUseCase: AddAnimalUseCase,
    private val getAnimalProjectionUseCase: GetAnimalProjectionUseCase
) {
    @PostMapping("/animal")
    fun postAnimal(
        authentication: Authentication,
        @RequestBody request: NewAnimalRequest
    ) = addAnimalUseCase(
        authentication.toCurrentUser(),
        request
    )

    @GetMapping("/animal/projection")
    fun getAnimalProjection(
        authentication: Authentication,
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = getAnimalProjectionUseCase(
        authentication.toCurrentUser(),
        text,
        page - 1
    )
}