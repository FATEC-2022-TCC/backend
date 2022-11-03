package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.UpdateComplaintRequest
import com.fatec.tcc.animais.status.domain.model.Status
import org.springframework.stereotype.Component

@Component
class AddCompliantStatusUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(
        request: UpdateComplaintRequest
    ) = repository.find(request.id) notFoundOrElse {
        request.status.run {
            Status(code, description, files.map(::Base64))
        }.also(statuses::add)
        run(repository::update)
    }
}