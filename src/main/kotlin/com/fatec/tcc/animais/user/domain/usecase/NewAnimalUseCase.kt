package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.base.ErrorCode
import com.fatec.tcc.animais.base.Result
import com.fatec.tcc.animais.base.error
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class NewAnimalUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(
        authentication: Authentication,
        newAnimalRequest: NewAnimalRequest,
        files: Array<MultipartFile>
    ): ResponseEntity<Result<Unit>> {
        val jwt = authentication.credentials as? Jwt
        val idString = jwt?.claims?.get("jti") as? String ?: return "User id not found" error ErrorCode.NOT_FOUND
        val user = userRepository.find(idString.toLong()) ?: return "User not found" error ErrorCode.NOT_FOUND
        val animal = Animal(
            name = newAnimalRequest.name,
            description = newAnimalRequest.description,
            type = newAnimalRequest.type,
            birth = newAnimalRequest.birth
        )
        val animals = user.animals.toMutableList().apply {
            add(animal)
        }
        userRepository.update(
            user.copy(
                animals = animals
            )
        )
        return ResponseEntity.ok().build()
    }
}