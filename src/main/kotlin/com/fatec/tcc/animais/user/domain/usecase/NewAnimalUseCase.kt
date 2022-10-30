package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.security.CurrentUser
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException

@Component
class NewAnimalUseCase(
    private val repository: BaseRepository<User>
) {
    operator fun invoke(
        currentUser: CurrentUser,
        newAnimalRequest: NewAnimalRequest,
        files: Array<MultipartFile>
    ) {
        val user = repository.find(currentUser.id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val animal = Animal(
            name = newAnimalRequest.name,
            description = newAnimalRequest.description,
            type = newAnimalRequest.type,
            birth = newAnimalRequest.birth
        )
        val animals = user.animals.toMutableList().apply {
            add(animal)
        }
        repository.update(
            user.copy(
                animals = animals
            )
        )
    }
}