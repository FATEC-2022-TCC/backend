package com.fatec.tcc.animais.category.domain.usecase

import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.category.domain.repository.CategoryProjectionRepository

@UseCase
class GetAllCategoryProjectionUseCase(
    private val repository: CategoryProjectionRepository
) {
    operator fun invoke() = repository.all()
}