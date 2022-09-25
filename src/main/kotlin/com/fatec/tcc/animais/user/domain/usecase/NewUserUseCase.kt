package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.security.Scope
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.model.NewUserRequest
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class NewUserUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(newUserRequest: NewUserRequest): ResponseEntity<Result<User>> {
        val databaseUser = userRepository.find(newUserRequest.username)
        if (databaseUser != null) return "Username ${newUserRequest.username} already exists" error ErrorCode.ALREADY_EXISTS
        val password = passwordEncoder.encode(newUserRequest.password)
        return userRepository.insert(
            User(
                name = newUserRequest.name,
                username = newUserRequest.username,
                password = password,
                authorities = Scope.NORMAL.toString()
            )
        ).success()
    }
}