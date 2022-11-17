package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusEnum
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRequestProjectionRepository
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.security.CurrentUser
import com.fatec.tcc.animais.status.domain.model.Status

@UseCase
class AddUserAdoptionRequestUseCase(
    private val adoptionRequestProjectionRepository: AdoptionRequestProjectionRepository,
    private val repository: BaseRepository<Adoption>
) {
    operator fun invoke(
        id: Long,
        currentUser: CurrentUser
    ) {
        if (adoptionRequestProjectionRepository.getByCreatedBy(currentUser.username) != null) return
        val adoption = repository.find(id).notNullOrThrow()
        adoption.requests.add(
            AdoptionRequest(
                -1,
                arrayListOf(
                    Status(
                        AdoptionRequestStatusEnum.REQUESTED.code,
                        AdoptionRequestStatusEnum.REQUESTED.description
                    )
                ),
                AdoptionRequestStatusEnum.REQUESTED.code
            )
        )
        repository.update(adoption)
    }
}