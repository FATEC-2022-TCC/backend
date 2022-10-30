package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import org.springframework.stereotype.Component

@Component
class SearchContentProjectionUseCase(
    private val repository: SearchableRepository<ContentProjection, String>
) {
    operator fun invoke(
        data: String,
        page: Int,
    ) = repository.search(
        data,
        page,
        1
    )
}