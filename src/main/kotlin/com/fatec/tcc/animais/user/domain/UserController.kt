package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.base.trySuccess
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val newUserUseCase: NewUserUseCase
) {
    @GetMapping
    fun get(): List<User> = userRepository.all()

    @PostMapping
    fun post(@RequestBody user: User) = newUserUseCase(user)

    @GetMapping("/{id}")
    fun get(id: Long) = userRepository.find(id).trySuccess()
}