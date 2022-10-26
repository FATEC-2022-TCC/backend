package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.user.domain.model.Scope
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class SignUpUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(signUpRequest: SignUpRequest): User {
        val databaseUser = userRepository.find(signUpRequest.username)
        if (databaseUser != null) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        val password = passwordEncoder.encode(signUpRequest.password)
        return userRepository.insert(
            User(
                name = signUpRequest.name,
                username = signUpRequest.username,
                email = signUpRequest.email,
                password = password,
                authority = "${Scope.NORMAL}"
            )
        )
    }
}