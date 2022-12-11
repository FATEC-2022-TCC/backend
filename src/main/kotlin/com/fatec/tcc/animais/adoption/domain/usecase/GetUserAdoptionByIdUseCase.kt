package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.security.CurrentUser

@UseCase
class GetUserAdoptionByIdUseCase(
    private val adoptionRepository: AdoptionRepository
) {
    operator fun invoke(
        id: Long,
        currentUser: CurrentUser
    ) = adoptionRepository.findByCreatedByAndId(
        id, currentUser.username
    ).notNullOrThrow()
}