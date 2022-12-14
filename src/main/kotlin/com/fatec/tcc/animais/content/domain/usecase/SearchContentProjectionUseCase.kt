package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchContentProjectionUseCase(
    private val repository: SearchableRepository<ContentProjection, String>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        data: String,
        page: Int,
    ) = repository.search(
        data,
        page,
        paginationCounter
    )
}