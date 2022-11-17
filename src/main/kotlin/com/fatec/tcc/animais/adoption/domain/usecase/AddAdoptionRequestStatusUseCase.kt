package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusStateMachine
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.adoption.domain.model.UpdateAdoptionRequestRequest
import com.fatec.tcc.animais.base.*
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class AddAdoptionRequestStatusUseCase(
    private val repository: BaseRepository<AdoptionRequest>
) {
    operator fun invoke(
        request: UpdateAdoptionRequestRequest
    ) = repository.find(request.id) notFoundOrElse {
        val currentStatus = AdoptionRequestStatusStateMachine[currentStatusCode].notNullOrThrow()
        val desiredStatus = AdoptionRequestStatusStateMachine[request.status.code].notNullOrThrow()
        AdoptionRequestStatusStateMachine.isStateChangeAllowed(currentStatus, desiredStatus).trueOrThrow()
        request.status.run {
            Status(code, description, files.map(::Base64))
        }.also(statuses::add)
        copy(
            currentStatusCode = request.status.code
        ).run(repository::update)
    }
}