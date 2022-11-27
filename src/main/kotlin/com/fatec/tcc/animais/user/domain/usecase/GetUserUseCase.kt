package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.user.domain.model.User

@UseCase
class GetUserUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id).notNullOrThrow()
}