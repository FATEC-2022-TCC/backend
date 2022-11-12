package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.AnimalProjection
import com.fatec.tcc.animais.animal.domain.repository.AnimalProjectionRepositoryData
import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.security.CurrentUser
import org.springframework.beans.factory.annotation.Value

@UseCase
class GetAnimalProjectionUseCase(
    private val repository: SearchableRepository<AnimalProjection, AnimalProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(currentUser: CurrentUser, text: String, page: Int) = repository
        .search(
            AnimalProjectionRepositoryData(
                currentUser.id,
                text
            ),
            page,
            paginationCounter
        )
}