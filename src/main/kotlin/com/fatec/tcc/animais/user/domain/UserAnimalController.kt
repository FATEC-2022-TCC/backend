package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.repository.AnimalProjectionRepositoryData
import com.fatec.tcc.animais.animal.domain.usecase.*
import com.fatec.tcc.animais.security.currentUser
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
        authentication.currentUser,
        request
    )

    @GetMapping("/{id}")
    fun get(
        authentication: Authentication,
        @PathVariable id: Long
    ) = getAnimalUseCase(authentication.currentUser, id)

    @GetMapping("/projection")
    fun projection(
        authentication: Authentication,
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = getAnimalProjectionUseCase(
        AnimalProjectionRepositoryData(
            authentication.currentUser.id,
            text
        ),
        page - 1
    )

    @PutMapping
    fun put(
        authentication: Authentication,
        @RequestBody request: UpdateAnimalRequest
    ) = updateAnimalUseCase(
        authentication.currentUser,
        request
    )

    @DeleteMapping("/{id}")
    fun delete(
        authentication: Authentication,
        @PathVariable id: Long
    ) = deleteAnimalUseCase(
        authentication.currentUser,
        id
    )
}