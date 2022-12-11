package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.security.CurrentUser
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.model.UserUpdatePasswordRequest
import org.springframework.security.crypto.password.PasswordEncoder

@UseCase
class UserUpdateUserPasswordUseCase(
    private val repository: BaseRepository<User>,
    private val passwordEncoder: PasswordEncoder
) {
    operator fun invoke(
        currentUser: CurrentUser,
        request: UserUpdatePasswordRequest
    ) = repository.find(currentUser.id) notFoundOrUnit {
        copy(
            password = passwordEncoder.encode(request.password)
        ).run(repository::update)
    }
}