package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjectionRepositoryData
import com.fatec.tcc.animais.base.SearchProjectionAndStatusesResponse
import com.fatec.tcc.animais.base.SearchableRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SearchAdoptionProjectionUseCase(
    private val repository: SearchableRepository<AdoptionProjection, AdoptionProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: AdoptionProjectionRepositoryData,
        page: Int,
    ) = SearchProjectionAndStatusesResponse(
        page = repository.search(
            data,
            page,
            paginationCounter
        ),
        statuses = AdoptionStatusEnum.values().map(AdoptionStatusEnum::toStateDescription)
    )
}