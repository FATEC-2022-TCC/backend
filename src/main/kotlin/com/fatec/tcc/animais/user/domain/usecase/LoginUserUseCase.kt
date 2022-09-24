package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.security.GenerateTokenUseCase
import com.fatec.tcc.animais.user.domain.model.Login
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
    operator fun invoke(login: Login): ResponseEntity<Result<Token>> {
        val user = userRepository.find(login.username)
            ?: return "User ${login.username} not found" error ErrorCode.NOT_FOUND
        val match = passwordEncoder.matches(login.password, user.password)
        if (!match) {
            return "User's password is incorrect" error ErrorCode.NOT_FOUND
        }
        val userDetails = User.builder().apply {
            username(user.username)
            password(user.password)
            authorities(emptyList())
        }.build()
        val token = generateTokenUseCase(userDetails)
        return Token(token).success()
    }
}