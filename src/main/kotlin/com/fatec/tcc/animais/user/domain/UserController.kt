package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.base.trySuccess
import com.fatec.tcc.animais.user.domain.model.Login
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import com.fatec.tcc.animais.user.domain.usecase.LoginUserUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.context.annotation.Role
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val newUserUseCase: NewUserUseCase,
    private val loginUseCase: LoginUserUseCase
) {
    @RolesAllowed("admin")
    @GetMapping
    fun get(authentication: Authentication): List<User> =
        userRepository.all()

    @PostMapping
    fun post(@RequestBody user: User) = newUserUseCase(user)

    @PostMapping("/login")
    fun login(@RequestBody login: Login) = loginUseCase(login)

    @GetMapping("/{id}")
    fun get(id: Long) = userRepository.find(id).trySuccess()
}