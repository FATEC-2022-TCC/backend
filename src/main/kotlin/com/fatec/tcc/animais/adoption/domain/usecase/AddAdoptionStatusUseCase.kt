package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusStateMachine
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.model.UpdateAdoptionRequest
import com.fatec.tcc.animais.base.*
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class AddAdoptionStatusUseCase(
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(
        request: UpdateAdoptionRequest
    ) = repository.find(request.id) notFoundOrElse {
        val currentStatus = AdoptionStatusStateMachine[currentStatusCode].notNullOrThrow()
        val desiredStatus = AdoptionStatusStateMachine[request.status.code].notNullOrThrow()
        AdoptionStatusStateMachine.isStateChangeAllowed(currentStatus, desiredStatus).trueOrThrow()
        request.status.run {
            Status(code, description, files.map(::Base64))
        }.also(statuses::add)
        copy(
            currentStatusCode = request.status.code
        ).run(repository::update)
        Unit
    }
}