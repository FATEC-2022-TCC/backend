package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusStateMachine
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.base.*

@UseCase
class GetAdoptionUseCase(
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id) notFoundOrElse {
        val currentStatus = AdoptionStatusStateMachine[currentStatusCode].notNullOrThrow()
        DataAndAllowedStatus(
            data = this,
            allowedStatus = AdoptionStatusStateMachine
                .getAvailableStates(currentStatus)
                .map(AdoptionStatusEnum::toStateDescription)
        )
    }
}