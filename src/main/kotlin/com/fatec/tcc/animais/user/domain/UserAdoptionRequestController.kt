package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.adoption.domain.usecase.AddUserAdoptionRequestUseCase
import com.fatec.tcc.animais.security.toCurrentUser
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user/adoption/request")
class UserAdoptionRequestController(
    private val addUserAdoptionRequestUseCase: AddUserAdoptionRequestUseCase
) {
    @GetMapping
    fun post(
        @RequestParam(defaultValue = "0") id: Long,
        authentication: Authentication
    ) = addUserAdoptionRequestUseCase(
        id,
        authentication.toCurrentUser()
    )
}