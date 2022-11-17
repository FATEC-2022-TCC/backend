package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjectionRepositoryData
import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchAdoptionRequestProjectionUseCase(
    private val repository: SearchableRepository<AdoptionRequestProjection, AdoptionRequestProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: AdoptionRequestProjectionRepositoryData,
        page: Int
    ) = repository.search(
        data,
        page,
        paginationCounter
    )
}