package com.fatec.tcc.animais.category.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.category.domain.model.Category
import com.fatec.tcc.animais.category.domain.model.UpdateCategoryRequest

@UseCase
class UpdateCategoryUseCase(
    private val repository: BaseRepository<Category>
) {
    operator fun invoke(
        request: UpdateCategoryRequest
    ) = repository.find(request.id) notFoundOrElse {
        copy(
            name = request.name,
            description = request.description,
            images = request.images.map(::Base64) as ArrayList,
            files = request.files.map(::Base64) as ArrayList
        ).run(repository::update)
    }
}