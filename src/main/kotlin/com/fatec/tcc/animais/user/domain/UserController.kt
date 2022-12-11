package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.security.currentUser
import com.fatec.tcc.animais.user.domain.model.UserUpdatePasswordRequest
import com.fatec.tcc.animais.user.domain.usecase.UserUpdateUserPasswordUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userUpdateUserPasswordUseCase: UserUpdateUserPasswordUseCase
) {
    @PutMapping("/password")
    fun password(
        authentication: Authentication,
        @RequestBody request: UserUpdatePasswordRequest
    ) = userUpdateUserPasswordUseCase(
        authentication.currentUser,
        request
    )
}