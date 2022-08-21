package com.fatec.tcc.animais.user.domain

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository
) {
    @GetMapping
    fun all(): List<User> =
        userRepository.all()

    @PostMapping
    fun insert(@RequestBody user: User): User =
        userRepository.insert(user)
}