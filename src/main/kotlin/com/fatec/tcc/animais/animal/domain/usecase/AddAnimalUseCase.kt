package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.base.notFoundOrUnit
import com.fatec.tcc.animais.category.domain.model.Category
import com.fatec.tcc.animais.security.CurrentUser
import com.fatec.tcc.animais.user.domain.model.User

@UseCase
class AddAnimalUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        currentUser: CurrentUser,
        request: NewAnimalRequest
    ) = repository.find(currentUser.id) notFoundOrUnit {
        Animal(
            picture = request.picture,
            name = request.name,
            category = Category(request.categoryId),
            gender = request.gender,
            age = request.age,
            size = request.size,
            description = request.description
        ).run(animals::add)
        run(repository::update)
    }
}