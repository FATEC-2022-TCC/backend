package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository

@UseCase
class DeleteNonValidatedUsersUseCase(
    private val userRepository: UserRepository,
    private val repository: BaseRepository<User>
) {
    operator fun invoke() = userRepository
        .findByIsValidated(false)
        .map(User::id)
        .run(repository::delete)
}