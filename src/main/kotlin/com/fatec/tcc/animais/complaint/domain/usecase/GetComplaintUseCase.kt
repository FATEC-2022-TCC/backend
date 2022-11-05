package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusStateMachine
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.GetCompliantResponse
import org.springframework.stereotype.Component

@Component
class GetComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id) notFoundOrElse {
        val currentStatus = ComplaintStatusEnum[currentStatusCode].notNullOrThrow()
        GetCompliantResponse(
            complaint = this,
            allowedStatus = ComplaintStatusStateMachine
                .getAvailableStates(currentStatus)
                .map(ComplaintStatusEnum::toComplaintStatus)
        )
    }
}