package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.user.domain.model.Scope
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.server.ResponseStatusException

@UseCase
class SignUpUseCase(
    private val userRepository: UserRepository,
    private val userBaseRepository: BaseRepository<User>,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(signUpRequest: SignUpRequest): User {
        val databaseUser = userRepository.findByUsername(signUpRequest.username)
        if (databaseUser != null) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        val password = passwordEncoder.encode(signUpRequest.password)
        val (name, username, email) = signUpRequest
        return userBaseRepository.insert(
            User(
                name = name,
                username = username,
                email = email,
                password = password,
                authority = "${Scope.NORMAL}"
            )
        )
    }
}