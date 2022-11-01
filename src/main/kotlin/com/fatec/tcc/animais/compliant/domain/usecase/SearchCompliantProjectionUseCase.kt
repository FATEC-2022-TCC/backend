package com.fatec.tcc.animais.compliant.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.compliant.domain.model.CompliantProjection
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SearchCompliantProjectionUseCase(
    private val repository: SearchableRepository<CompliantProjection, CompliantProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: CompliantProjectionRepositoryData,
        page: Int
    ) = repository.search(
        data,
        page,
        paginationCounter
    )
}