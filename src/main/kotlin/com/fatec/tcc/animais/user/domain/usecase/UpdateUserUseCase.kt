package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.user.domain.model.UpdateUserRequest
import com.fatec.tcc.animais.user.domain.model.User

@UseCase
class UpdateUserUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        request: UpdateUserRequest
    ) = repository.find(request.id) notFoundOrElse {
        copy(
            name = request.name,
            email = request.email,
            authority = request.authority,
            isActive = request.isActive
        ).run(repository::update)
        Unit
    }
}