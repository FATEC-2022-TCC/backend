package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.adoption.domain.usecase.GetUserAdoptionByIdUseCase
import com.fatec.tcc.animais.adoption.domain.usecase.GetUserAdoptionProjectionUseCase
import com.fatec.tcc.animais.security.currentUser
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user/adoption")
class UserAdoptionController(
    private val getUserAdoptionByIdUseCase: GetUserAdoptionByIdUseCase,
    private val getUserAdoptionProjectionUseCase: GetUserAdoptionProjectionUseCase
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long,
        authentication: Authentication
    ) = getUserAdoptionByIdUseCase(
        id,
        authentication.currentUser
    )

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int,
        authentication: Authentication
    ) = getUserAdoptionProjectionUseCase(
        text,
        page - 1,
        authentication.currentUser
    )
}