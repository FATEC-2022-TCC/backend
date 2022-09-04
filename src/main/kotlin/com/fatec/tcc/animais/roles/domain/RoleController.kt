package com.fatec.tcc.animais.roles.domain

import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/role")
class RoleController(
    private val userRepository: UserRepository
) {
    @PostMapping
    fun post(
        @RequestParam userId: Long,
        @RequestBody role: Role
    ): ResponseEntity<User> {
        val user = userRepository.find(userId) ?: return ResponseEntity.notFound().build()
        val roles = user.roles.toMutableList().apply {
            add(role)
        }
        val new = user.copy(roles = roles)
        return ResponseEntity.ok(userRepository.update(new))
    }
}