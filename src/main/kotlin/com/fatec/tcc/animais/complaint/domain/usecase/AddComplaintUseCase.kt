package com.fatec.tcc.animais.complaint.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.complaint.domain.model.NewComplaintRequest
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class AddComplaintUseCase(
    private val repository: BaseRepository<Complaint>
) {
    operator fun invoke(request: NewComplaintRequest) = request.run {
        Complaint(
            -1,
            local,
            description,
            images.map(::Base64),
            arrayListOf(
                Status(
                    ComplaintStatusEnum.CREATED.code,
                    ComplaintStatusEnum.CREATED.description
                )
            ),
            ComplaintStatusEnum.CREATED.code
        )
    }.run(repository::insert)
}