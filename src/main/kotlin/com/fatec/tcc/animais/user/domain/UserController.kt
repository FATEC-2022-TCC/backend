package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.animal.domain.model.NewAnimalRequest
import com.fatec.tcc.animais.security.toCurrentUser
import com.fatec.tcc.animais.user.domain.usecase.LoginUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewAnimalUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/user")
class UserController(
    private val newUserUseCase: NewUserUseCase,
    private val loginUseCase: LoginUseCase,
    private val newAnimalUseCase: NewAnimalUseCase
) {
    @PostMapping(
        "/animal",
        consumes = [
            MediaType.APPLICATION_FORM_URLENCODED_VALUE
        ]
    )
    fun newAnimal(
        authentication: Authentication,
        @RequestPart("animal") newAnimalRequest: NewAnimalRequest,
        @RequestPart("files", required = false) files: Array<MultipartFile>
    ) = newAnimalUseCase(authentication.toCurrentUser(), newAnimalRequest, files)
}