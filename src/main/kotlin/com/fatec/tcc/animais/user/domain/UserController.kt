package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.trySuccess
import com.fatec.tcc.animais.user.domain.model.Login
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import com.fatec.tcc.animais.user.domain.usecase.LoginUserUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewAnimalUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val newUserUseCase: NewUserUseCase,
    private val loginUseCase: LoginUserUseCase,
    private val newAnimalUseCase: NewAnimalUseCase
) {
    @PostMapping
    fun post(@RequestBody user: User) = newUserUseCase(user)

    @PostMapping("/login")
    fun login(@RequestBody login: Login) = loginUseCase(login)

    @PostMapping("/animal")
    fun newAnimal(authentication: Authentication, @RequestBody animal: Animal) =
        newAnimalUseCase(authentication, animal)
}