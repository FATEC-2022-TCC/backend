package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.user.domain.model.UpdateUserPasswordRequest
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.security.crypto.password.PasswordEncoder

@UseCase
class UpdateUserPasswordUseCase(
    private val repository: BaseRepository<User>,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(
        request: UpdateUserPasswordRequest
    ) = repository.find(request.id) notFoundOrElse {
        val encoded = passwordEncoder.encode(request.password)
        copy(
            password = encoded
        ).run(repository::update)
        Unit
    }
}