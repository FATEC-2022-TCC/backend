package com.fatec.tcc.animais.compliant.domain.usecase

import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepository
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import org.springframework.stereotype.Component

@Component
class SearchCompliantProjectionUseCase(
    private val compliantProjectionRepository: CompliantProjectionRepository
) {
    operator fun invoke(
        data: CompliantProjectionRepositoryData,
        page: Int
    ) = compliantProjectionRepository.search(
        data,
        page,
        1
    )
}