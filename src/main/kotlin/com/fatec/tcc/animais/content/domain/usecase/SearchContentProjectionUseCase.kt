package com.fatec.tcc.animais.content.domain.usecase

import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Component

@Component
class SearchContentProjectionUseCase(
    private val contentProjectionRepository: ContentProjectionRepository
) {
    operator fun invoke(
        data: String,
        page: Int,
    ) = contentProjectionRepository.search(
        data,
        page,
        1
    )
}