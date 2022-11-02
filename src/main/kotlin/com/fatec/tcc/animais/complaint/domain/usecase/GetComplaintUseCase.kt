package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class GetComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(id: Long) =
        repository.find(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}