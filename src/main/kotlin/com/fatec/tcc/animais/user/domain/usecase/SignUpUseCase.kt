package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.trueOrThrow
import com.fatec.tcc.animais.user.domain.model.Scope
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder

@UseCase
class SignUpUseCase(
    private val userRepository: UserRepository,
    private val userBaseRepository: BaseRepository<User>,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(signUpRequest: SignUpRequest): User {
        val (name, username, email) = signUpRequest
        val existingUser = userRepository.findByUsername(username)
        (existingUser != null).trueOrThrow()
        val encoded = passwordEncoder.encode(signUpRequest.password)
        return userBaseRepository.insert(
            User(
                name = name,
                username = username,
                email = email,
                password = encoded,
                authority = "${Scope.NORMAL}",
                isActive = true
            )
        )
    }
}