package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class FinishANonSuccessfulAdoptionUseCase(
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(
        adoption: Adoption
    ) {
        adoption.apply {
            val mappedRequests = requests.map {
                if (it.currentStatusCode != AdoptionRequestStatusEnum.CANCELED.code) {
                    it.apply {
                        statuses.add(
                            Status(
                                AdoptionRequestStatusEnum.CANCELED.code,
                                AdoptionRequestStatusEnum.CANCELED.description
                            )
                        )
                    }.copy(
                        currentStatusCode = AdoptionRequestStatusEnum.CANCELED.code
                    )
                } else {
                    it
                }
            }
            copy(
                requests = mappedRequests as ArrayList
            ).run(repository::update)
        }
    }
}