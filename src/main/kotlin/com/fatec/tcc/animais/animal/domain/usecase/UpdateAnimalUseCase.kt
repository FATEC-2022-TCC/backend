package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.UpdateAnimalRequest
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse

@UseCase
class UpdateAnimalUseCase(
    private val repository: BaseRepository<Animal>
) {
    operator fun invoke(
        request: UpdateAnimalRequest
    ) = repository.find(request.id) notFoundOrElse {
        copy(
            picture = request.picture,
            name = request.name,
            specie = request.specie,
            gender = request.gender,
            age = request.age,
            size = request.size,
            about = request.about
        ).run(repository::update)
    }
}