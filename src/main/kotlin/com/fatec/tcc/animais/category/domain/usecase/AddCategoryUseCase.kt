package com.fatec.tcc.animais.category.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.category.domain.model.AddCategoryRequest
import com.fatec.tcc.animais.category.domain.model.Category

@UseCase
class AddCategoryUseCase(
    private val repository: BaseRepository<Category>
) {
    operator fun invoke(
        request: AddCategoryRequest
    ) = request.run {
        Category(name, description)
    }.run(repository::insert)
}