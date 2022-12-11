package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.user.domain.model.AdminUpdateUserPasswordRequest
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.security.crypto.password.PasswordEncoder

@UseCase
class AdminUpdateUserPasswordUseCase(
    private val repository: BaseRepository<User>,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(
        request: AdminUpdateUserPasswordRequest
    ) = repository.find(request.id) notFoundOrUnit {
        val encoded = passwordEncoder.encode(request.password)
        copy(
            password = encoded
        ).run(repository::update)
    }
}