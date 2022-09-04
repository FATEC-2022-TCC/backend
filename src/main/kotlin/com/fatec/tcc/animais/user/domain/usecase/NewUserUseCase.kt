package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class NewUserUseCase(
    private val userRepository: UserRepository
) {
    @Throws(IllegalStateException::class)
    operator fun invoke(user: User): ResponseEntity<Result<User>> {
        if (user.id != -1L) {
            val messageCode = "User's id must be -1. It was ${user.id}" to ErrorCode.INVALID_LOGIC
            return messageCode.error()
        }
        val databaseUser = userRepository.find(user.username)
        if (databaseUser != null) {
            val messageCode = "Username ${user.username} already exists" to ErrorCode.ALREADY_EXISTS
            return messageCode.error()
        }
        return userRepository.insert(user).success()
    }
}