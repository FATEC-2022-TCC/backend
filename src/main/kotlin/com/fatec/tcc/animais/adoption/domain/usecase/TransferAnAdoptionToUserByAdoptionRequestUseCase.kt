package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRepository
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notNullOrThrow
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository

@UseCase
class TransferAnAdoptionToUserByAdoptionRequestUseCase(
    private val adoptionRepository: AdoptionRepository,
    private val userRepository: UserRepository,
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        adoptionRequest: AdoptionRequest
    ) {
        val adoption = adoptionRepository.findByAdoptionRequestId(adoptionRequest.id).notNullOrThrow()
        val username = adoptionRequest.createdBy.notNullOrThrow()
        val user = userRepository.findByUsername(username).notNullOrThrow()
        val (_, name, description, gender, size, age, category, picture) = adoption
        user.animals.add(
            Animal(
                -1,
                name,
                description,
                gender,
                size,
                age,
                category,
                picture
            )
        )
        repository.update(user)
    }
}