package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.security.GenerateTokenUseCase
import com.fatec.tcc.animais.user.domain.model.LoginRequest
import com.fatec.tcc.animais.user.domain.model.Token
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.authority.AuthorityUtils.createAuthorityList
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class LoginUserUseCase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val generateTokenUseCase: GenerateTokenUseCase
) {
    operator fun invoke(request: LoginRequest): Token {
        val (username, password) = request
        val user = userRepository.find(username) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val match = passwordEncoder.matches(password, user.password)
        if (!match) throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val userDetails = User.builder().apply {
            username(user.username)
            password(user.password)
            val authorities = user.authorities.split(" ").toTypedArray()
            authorities(createAuthorityList(*authorities))
        }.build()
        return generateTokenUseCase(userDetails, user.id).run(::Token)
    }
}