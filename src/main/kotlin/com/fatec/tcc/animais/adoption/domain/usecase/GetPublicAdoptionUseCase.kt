package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.model.PublicAdoption
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base.trueOrThrow

@UseCase
class GetPublicAdoptionUseCase(
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(id: Long) = repository.find(id) notFoundOrElse {
        (currentStatusCode == AdoptionStatusEnum.VISIBLE.code).trueOrThrow()
        PublicAdoption(
            id,
            name,
            description,
            gender,
            size,
            category,
            picture,
            images,
            created
        )
    }
}