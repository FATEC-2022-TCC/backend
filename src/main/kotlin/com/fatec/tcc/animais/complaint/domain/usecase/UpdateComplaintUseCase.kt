package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.UpdateComplaintRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class UpdateComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(request: UpdateComplaintRequest) = repository
        .find(request.id)
        ?.apply {
            statuses.add(request.status)
        }
        ?.run(repository::update)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}