package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.user.domain.model.LoginRequest
import com.fatec.tcc.animais.user.domain.model.NewUserRequest
import com.fatec.tcc.animais.user.domain.usecase.LoginUserUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewAnimalUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val newUserUseCase: NewUserUseCase,
    private val loginUseCase: LoginUserUseCase,
    private val newAnimalUseCase: NewAnimalUseCase
) {
    @PostMapping
    fun post(@RequestBody newUserRequest: NewUserRequest) = newUserUseCase(newUserRequest)

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest) = loginUseCase(loginRequest)

    @PostMapping("/animal")
    fun newAnimal(authentication: Authentication, @RequestBody newAnimalRequest: NewAnimalRequest) = newAnimalUseCase(authentication, newAnimalRequest)
}