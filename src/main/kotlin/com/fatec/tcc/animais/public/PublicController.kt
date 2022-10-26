package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionInEvidenceUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentUseCase
import com.fatec.tcc.animais.user.domain.model.SignInRequest
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.usecase.LoginUseCase
import com.fatec.tcc.animais.user.domain.usecase.NewUserUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public")
class PublicController(
    private val newUserUseCase: NewUserUseCase,
    private val loginUseCase: LoginUseCase,
    private val getContentProjectionInEvidenceUseCase: GetContentProjectionInEvidenceUseCase,
    private val getContentUseCase: GetContentUseCase
) {
    @PostMapping("/signup")
    fun newUser(
        @RequestBody request: SignUpRequest
    ) = newUserUseCase(request)

    @PostMapping("/signin")
    fun login(
        @RequestBody request: SignInRequest
    ) = loginUseCase(request)

    @GetMapping("/content/projection/evidence")
    fun getContentProjectionInEvidence() =
        getContentProjectionInEvidenceUseCase()

    @GetMapping("/content/{id}")
    fun getContent(
        @PathVariable id: Long
    ) = getContentUseCase(id)
}