package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.user.domain.model.SignInRequest
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.usecase.SignInUseCase
import com.fatec.tcc.animais.user.domain.usecase.SignUpUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public/sign")
class PublicSignController(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase
) {
    @PostMapping("/up")
    fun up(
        @RequestBody request: SignUpRequest
    ) = signUpUseCase(request)

    @PostMapping("/in")
    fun `in`(
        @RequestBody request: SignInRequest
    ) = signInUseCase(request)
}