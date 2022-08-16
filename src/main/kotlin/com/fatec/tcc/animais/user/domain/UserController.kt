package com.fatec.tcc.animais.user.domain

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
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