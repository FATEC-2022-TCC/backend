package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.security.GenerateTokenUseCase
import com.fatec.tcc.animais.user.domain.model.LoginRequest
import com.fatec.tcc.animais.user.domain.model.Token
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class LoginUserUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val generateTokenUseCase: GenerateTokenUseCase
) {
    operator fun invoke(loginRequest: LoginRequest): ResponseEntity<Result<Token>> {
        val user = userRepository.find(loginRequest.username)
            ?: return "User ${loginRequest.username} not found" error ErrorCode.NOT_FOUND
        val match = passwordEncoder.matches(loginRequest.password, user.password)
        if (!match) return "User's password is incorrect" error ErrorCode.NOT_FOUND
        val userDetails = User.builder().apply {
            username(user.username)
            password(user.password)
            authorities(emptyList())
        }.build()
        val token = generateTokenUseCase(userDetails, user.id)
        return Token(token).success()
    }
}