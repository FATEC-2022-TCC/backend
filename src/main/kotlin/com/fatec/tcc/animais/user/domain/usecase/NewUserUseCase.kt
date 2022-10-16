package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.user.domain.model.Scope
import com.fatec.tcc.animais.user.domain.model.NewUserRequest
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class NewUserUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(newUserRequest: NewUserRequest): User {
        val databaseUser = userRepository.find(newUserRequest.username)
        if (databaseUser != null) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        val password = passwordEncoder.encode(newUserRequest.password)
        return userRepository.insert(
            User(
                name = newUserRequest.name,
                username = newUserRequest.username,
                password = password,
                authority = "${Scope.NORMAL}"
            )
        )
    }
}