package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusStateMachine
import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection
import com.fatec.tcc.animais.complaint.domain.model.SearchComplaintProjectionResponse
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintProjectionRepositoryData
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchComplaintProjectionUseCase(
    private val repository: SearchableRepository<ComplaintProjection, ComplaintProjectionRepositoryData>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: ComplaintProjectionRepositoryData,
        page: Int
    ) = SearchComplaintProjectionResponse(
        page = repository.search(
            data,
            page,
            paginationCounter
        ),
        statuses = ComplaintStatusStateMachine.getAllStates().map(ComplaintStatusEnum::toStateDescription)
    )
}