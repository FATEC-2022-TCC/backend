package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintProjectionRepositoryData
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SearchComplaintProjectionUseCase(
    private val repository: SearchableRepository<ComplaintProjection, ComplaintProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: ComplaintProjectionRepositoryData,
        page: Int
    ) = repository.search(
        data,
        page,
        paginationCounter
    )
}