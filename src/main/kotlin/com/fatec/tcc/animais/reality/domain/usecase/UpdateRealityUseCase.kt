package com.fatec.tcc.animais.reality.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.reality.domain.model.Reality
import com.fatec.tcc.animais.reality.domain.model.UpdateRealityRequest

@UseCase
class UpdateRealityUseCase(
    private val repository: BaseRepository<Reality>
) {
    operator fun invoke(
        request: UpdateRealityRequest
    ) = repository.find(request.id) notFoundOrUnit {
        copy(
            data = request.data,
            scale = request.scale,
            title = request.title,
            description = request.description,
            background = request.background,
            isVisible = request.isVisible,
            images = request.images.map(::Base64) as ArrayList
        ).run(repository::update)
    }
}