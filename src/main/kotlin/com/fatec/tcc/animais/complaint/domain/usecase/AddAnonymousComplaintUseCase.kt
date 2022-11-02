package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatuses
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.NewComplaintRequest
import com.fatec.tcc.animais.status.domain.model.Status
import org.springframework.stereotype.Component
import java.time.Instant

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
                    code = ComplaintStatuses.CREATED.code,
                    description = "A denúncia foi criada",
                )
            ),
            Instant.now(),
            Instant.now()
        )
    }.run(repository::insert)
}