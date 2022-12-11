package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.user.domain.model.AdminUpdateUserRequest
import com.fatec.tcc.animais.user.domain.model.User

@UseCase
class AdminUpdateUserUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        request: AdminUpdateUserRequest
    ) = repository.find(request.id) notFoundOrUnit {
        copy(
            name = request.name,
            authority = request.authority,
            isActive = request.isActive,
            isValidated = true,
            privateInfo = privateInfo.run {
                val (email, telephony, identification, address, picture) = request.privateInfo
                copy(
                    email = email,
                    telephony = telephony,
                    identification = identification,
                    address = address,
                    picture = picture
                )
            }
        ).run(repository::update)
    }
}