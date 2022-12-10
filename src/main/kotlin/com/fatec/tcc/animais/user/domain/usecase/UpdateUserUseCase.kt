package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.user.domain.model.UpdateUserRequest
import com.fatec.tcc.animais.user.domain.model.User

@UseCase
class UpdateUserUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        request: UpdateUserRequest
    ) = repository.find(request.id) notFoundOrUnit {
        copy(
            name = request.name,
            authority = request.authority,
            isActive = request.isActive,
            isValidated = request.isValidated
        ).run(repository::update)
    }
}