package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.base.trueOrThrow
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusStateMachine
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.UpdateComplaintRequest
import com.fatec.tcc.animais.status.domain.model.Status
import org.springframework.stereotype.Component

@Component
class AddComplaintStatusUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(
        request: UpdateComplaintRequest
    ) = repository.find(request.id) notFoundOrElse {
        val currentStatus = ComplaintStatusEnum[currentStatusCode].notNullOrThrow()
        val desiredStatus = ComplaintStatusEnum[request.status.code].notNullOrThrow()
        ComplaintStatusStateMachine.isStateChangeAllowed(currentStatus, desiredStatus).trueOrThrow()
        request.status.run {
            Status(code, description, files.map(::Base64))
        }.also(statuses::add)
        copy(
            currentStatusCode = request.status.code
        ).run(repository::update)
    }
}