package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatus
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusStateMachine
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.GetCompliantResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class GetComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(
        id: Long
    ) = repository.find(id) notFoundOrElse {
        val currentStatus = ComplaintStatus[currentStatusCode].notNullOrThrow()
        GetCompliantResponse(
            complaint = this,
            allowedStatus = ComplaintStatusStateMachine.getAvailableStates(currentStatus)
        )
    }
}