package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.category.domain.model.Category
import com.fatec.tcc.animais.security.CurrentUser

@UseCase
class UpdateAnimalUseCase(
    private val repository: BaseRepository<Animal>,
    private val animalRepository: AnimalRepository
) {
    operator fun invoke(
        currentUser: CurrentUser,
        request: UpdateAnimalRequest
    ) = animalRepository.findByUserIdAndAnimalId(
        currentUser.id,
        request.id
    ) notFoundOrUnit {
        copy(
            picture = request.picture,
            name = request.name,
            category = Category(request.categoryId),
            gender = request.gender,
            age = request.age,
            size = request.size,
            description = request.description
        ).run(repository::update)
    }
}