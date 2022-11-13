package com.fatec.tcc.animais.category.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.category.domain.model.Category

@UseCase
class GetCategoryUseCase(
    private val repository: BaseRepository<Category>
) {
    operator fun invoke(id: Long) = repository.find(id).notNullOrThrow()
}