package com.fatec.tcc.animais.reality.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.reality.domain.model.NewRealityRequest
import com.fatec.tcc.animais.reality.domain.model.Reality

@UseCase
class AddRealityUseCase(
    private val repository: BaseRepository<Reality>
) {
    operator fun invoke(request: NewRealityRequest) {
        val (
            data,
            scale,
            title,
            description,
            background,
            images
        ) = request
        repository.insert(
            Reality(
                -1,
                data,
                scale,
                title,
                description,
                background,
                false,
                images.map(::Base64) as ArrayList
            )
        )
    }
}