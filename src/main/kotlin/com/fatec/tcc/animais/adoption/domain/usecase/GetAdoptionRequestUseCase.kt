package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusEnum
import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusStateMachine
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.base.*

@UseCase
class GetAdoptionRequestUseCase(
    private val repository: BaseRepository<AdoptionRequest>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id) notFoundOrElse {
        val currentStatus = AdoptionRequestStatusStateMachine[currentStatusCode].notNullOrThrow()
        DataAndAllowedStatus(
            data = this,
            allowedStatus = AdoptionRequestStatusStateMachine
                .getAvailableStates(currentStatus)
                .map(AdoptionRequestStatusEnum::toStateDescription)
        )
    }
}