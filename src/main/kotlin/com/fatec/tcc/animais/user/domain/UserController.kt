package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.extensions.asResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository
) {
    @GetMapping("/all")
    fun all(): List<User> = userRepository.all()

    @PostMapping
    fun insert(@RequestBody user: User) = userRepository.insert(user)

    @GetMapping
    fun get(@RequestParam userId: Long) = userRepository.find(userId).asResponse()
}