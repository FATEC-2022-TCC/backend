package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusEnum
import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRepository
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class FinishASuccessfulAdoptionUseCase(
    private val adoptionRepository: AdoptionRepository,
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(adoptionRequest: AdoptionRequest) =
        adoptionRepository.findByAdoptionRequestId(adoptionRequest.id) notFoundOrElse {
            val mappedRequests = requests.map {
                if (it.currentStatusCode != AdoptionRequestStatusEnum.CANCELED.code
                        && it.currentStatusCode != AdoptionRequestStatusEnum.ADOPTED.code) {
                    it.apply {
                        statuses.add(
                            Status(
                                AdoptionRequestStatusEnum.CANCELED.code,
                                "${AdoptionRequestStatusEnum.CANCELED.description}, pois foi adotada por outro usuário."
                            )
                        )
                    }.copy(
                        currentStatusCode = AdoptionRequestStatusEnum.CANCELED.code
                    )
                } else {
                    it
                }
            }
            statuses.add(
                Status(
                    AdoptionStatusEnum.ADOPTED.code,
                    "${AdoptionStatusEnum.ADOPTED.description} pelo usuário ${adoptionRequest.createdBy}"
                )
            )
            copy(
                currentStatusCode = AdoptionStatusEnum.ADOPTED.code,
                requests = mappedRequests as ArrayList
            ).run(repository::update)

            Unit
        }
}