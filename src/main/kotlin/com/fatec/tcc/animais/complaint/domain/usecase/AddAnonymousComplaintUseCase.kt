package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatus
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.NewComplaintRequest
import com.fatec.tcc.animais.status.domain.model.Status
import org.springframework.stereotype.Component

@Component
class AddAnonymousComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(request: NewComplaintRequest) = request.run {
        Complaint(
            -1,
            local,
            description,
            files.map(::Base64),
            arrayListOf(
                Status(
                    ComplaintStatus.CREATED.code,
                    "A denúncia foi criada",
                )
            )
        )
    }.run(repository::insert)
}