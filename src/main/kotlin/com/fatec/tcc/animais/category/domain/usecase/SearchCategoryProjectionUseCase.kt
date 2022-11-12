package com.fatec.tcc.animais.category.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.category.domain.model.CategoryProjection
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchCategoryProjectionUseCase(
    private val repository: SearchableRepository<CategoryProjection, String>,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        text: String,
        page:
        Int
    ) = repository.search(
        text,
        page,
        paginationCounter
    )
}