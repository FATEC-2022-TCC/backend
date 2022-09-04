package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class NewUserUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(user: User): ResponseEntity<Result<User>> {
        if (user.id != -1L) {
            return "User's id must be -1. It was ${user.id}" error ErrorCode.INVALID_LOGIC
        }
        val databaseUser = userRepository.find(user.username)
        if (databaseUser != null) {
            return "Username ${user.username} already exists" error ErrorCode.ALREADY_EXISTS
        }
        val password = passwordEncoder.encode(user.password)

        return userRepository.insert(
            user.copy(
                password = password
            )
        ).success()
    }
}