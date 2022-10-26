package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.compliant.domain.model.NewCompliantRequest
import com.fatec.tcc.animais.compliant.domain.usecase.AddCompliantUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionInEvidenceUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentUseCase
import com.fatec.tcc.animais.user.domain.model.SignInRequest
import com.fatec.tcc.animais.user.domain.model.SignUpRequest
import com.fatec.tcc.animais.user.domain.usecase.SignInUseCase
import com.fatec.tcc.animais.user.domain.usecase.SignUpUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public")
class PublicController(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase,
    private val getContentProjectionInEvidenceUseCase: GetContentProjectionInEvidenceUseCase,
    private val getContentUseCase: GetContentUseCase,
    private val addCompliantUseCase: AddCompliantUseCase
) {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody request: SignUpRequest
    ) = signUpUseCase(request)

    @PostMapping("/signin")
    fun signIn(
        @RequestBody request: SignInRequest
    ) = signInUseCase(request)

    @GetMapping("/content/projection/evidence")
    fun getContentProjectionInEvidence() =
        getContentProjectionInEvidenceUseCase()

    @GetMapping("/content/{id}")
    fun getContent(
        @PathVariable id: Long
    ) = getContentUseCase(id)

    @PostMapping("/compliant")
    fun compliant(
        @RequestBody request: NewCompliantRequest
    ) = addCompliantUseCase(request)
}