package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.content.domain.model.NewContentRequest
import com.fatec.tcc.animais.content.domain.usecase.AddContentUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin")
class AdminController(
    private val addContentUseCase: AddContentUseCase,
    private val getContentUseCase: GetContentUseCase,
    private val getContentProjectionUseCase: GetContentProjectionUseCase
) {
    @PostMapping("/content")
    fun postContent(
        @RequestBody request: NewContentRequest
    ) = addContentUseCase(request)

    @GetMapping("/content")
    fun getContent() = getContentUseCase()

    @GetMapping("/content/projection")
    fun getContentProjection() = getContentProjectionUseCase()
}