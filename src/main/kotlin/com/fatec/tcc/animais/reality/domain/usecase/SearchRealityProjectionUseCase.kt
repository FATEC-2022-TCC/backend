package com.fatec.tcc.animais.reality.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.reality.domain.model.RealityProjection
import com.fatec.tcc.animais.reality.domain.model.RealityProjectionRepositoryData
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchRealityProjectionUseCase(
    private val repository: SearchableRepository<RealityProjection, RealityProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: RealityProjectionRepositoryData,
        page: Int
    ) = repository.search(data, page, paginationCounter)
}