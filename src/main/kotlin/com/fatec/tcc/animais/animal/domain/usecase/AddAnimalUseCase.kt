package com.fatec.tcc.animais.animal.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base.notFoundOrElse
import com.fatec.tcc.animais.security.CurrentUser
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.stereotype.Component

@Component
class AddAnimalUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        currentUser: CurrentUser,
        request: NewAnimalRequest
    ) = repository.find(currentUser.id) notFoundOrElse {
        Animal(
            picture = request.picture,
            name = request.name,
            specie = request.specie,
            gender = request.gender,
            age = request.age,
            size = request.size,
            about = request.about
        ).run(animals::add)
        run(repository::update)
    }
}