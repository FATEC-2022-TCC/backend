package com.fatec.tcc.animais.user.domain.usecase

import com.fatec.tcc.animais.animal.domain.model.Animal
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Component

@Component
class NewAnimalUseCase {

    operator fun invoke(authentication: Authentication, animal: Animal) {
        val jwt = authentication.credentials as? Jwt ?: return
        val id = jwt.claims["jti"] as? String ?: return
        println(id)
    }
}