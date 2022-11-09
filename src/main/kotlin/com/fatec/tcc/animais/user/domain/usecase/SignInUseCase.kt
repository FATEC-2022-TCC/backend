package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.user.domain.model.SignInRequest
import com.fatec.tcc.animais.user.domain.model.SignInResponse
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.authority.AuthorityUtils.createAuthorityList
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class SignInUseCase(
    private val repository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val generateTokenUseCase: GenerateTokenUseCase
) {
    operator fun invoke(request: SignInRequest): SignInResponse {
        val (username, password) = request
        val user = repository.findByUsername(username).notNullOrThrow()
        val match = passwordEncoder.matches(password, user.password)
        if (!match) throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val userDetails = User.builder().apply {
            username(user.username)
            password(user.password)
            authorities(createAuthorityList(user.authority))
        }.build()
        val token = generateTokenUseCase(userDetails, user.id)
        val tokenType = user.authority
        return SignInResponse(
            token,
            tokenType
        )
    }
}