package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.model.NewAdoptionRequest
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.category.domain.model.Category
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class AddAdoptionUseCase(
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(
        request: NewAdoptionRequest
    ) = request.run {
        Adoption(
            -1,
            name,
            description,
            gender,
            size,
            Category(categoryId),
            picture,
            images.map(::Base64) as ArrayList,
            arrayListOf(
                Status(
                    AdoptionStatusEnum.CREATED.code,
                    AdoptionStatusEnum.CREATED.description
                )
            ),
            AdoptionStatusEnum.CREATED.code,
            arrayListOf()
        )
    }.run(repository::insert)
}