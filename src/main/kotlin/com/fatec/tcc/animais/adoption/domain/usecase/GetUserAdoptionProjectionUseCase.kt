package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.repository.AdoptionProjectionRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.security.CurrentUser
import org.springframework.beans.factory.annotation.Value

@UseCase
class GetUserAdoptionProjectionUseCase(
    private val repository: AdoptionProjectionRepository,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        page: Int,
        currentUser: CurrentUser
    ) = repository.projectAllByCreatedByRequest(
        currentUser.username,
        page,
        paginationCounter
    )
}