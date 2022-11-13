package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.*
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusStateMachine
import com.fatec.tcc.animais.complaint.domain.model.Complaint

@UseCase
class GetComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id) notFoundOrElse {
        val currentStatus = ComplaintStatusStateMachine[currentStatusCode].notNullOrThrow()
        DataAndAllowedStatus(
            data = this,
            allowedStatus = ComplaintStatusStateMachine
                .getAvailableStates(currentStatus)
                .map(ComplaintStatusEnum::toStateDescription)
        )
    }
}