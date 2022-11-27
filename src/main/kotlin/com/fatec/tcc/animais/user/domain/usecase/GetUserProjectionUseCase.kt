package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.user.data.repository.UserProjectionRepositoryData
import com.fatec.tcc.animais.user.domain.model.UserProjection
import org.springframework.beans.factory.annotation.Value

@UseCase
class GetUserProjectionUseCase(
    private val repository: SearchableRepository<UserProjection, UserProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: UserProjectionRepositoryData,
        page: Int
    ) = repository.search(
        data,
        page,
        paginationCounter
    )
}