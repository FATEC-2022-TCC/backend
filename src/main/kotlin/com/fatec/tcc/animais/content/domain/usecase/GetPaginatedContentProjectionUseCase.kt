package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Component

@Component
class GetPaginatedContentProjectionUseCase(
    private val contentProjectionRepository: ContentProjectionRepository
) {
    operator fun invoke(
        search: String,
        page: Int,
    ) = contentProjectionRepository.search(
        search,
        page,
        1
    )
}