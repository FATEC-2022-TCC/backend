package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.success
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Component

@Component
class NewAnimalUseCase(
    private val userRepository: UserRepository,
    private val animalRepository: AnimalRepository
) {

    operator fun invoke(authentication: Authentication, newAnimalRequest: NewAnimalRequest): ResponseEntity<Result<User>> {
        val jwt = authentication.credentials as? Jwt ?: return ResponseEntity.badRequest().build()
        val id = jwt.claims["jti"] as? String ?: return  ResponseEntity.badRequest().build()
        val user = userRepository.find(id)
        val animal = animalRepository.insert(
            Animal(
                id = -1,
                name = newAnimalRequest.name,
                description = newAnimalRequest.description,
                type = newAnimalRequest.type,
                birth = newAnimalRequest.birth
            )
        )
        if (user != null) {
            val animals: MutableList<Animal> = user.animals as MutableList<Animal>
            user.animals.add(animal)
            userRepository.update(user).success()
           return ResponseEntity.ok().build()
        }

        return ResponseEntity.notFound().build()

    }
}