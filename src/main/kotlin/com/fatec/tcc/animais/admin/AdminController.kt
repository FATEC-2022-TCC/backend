package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.usecase.AddContentUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin")
class AdminController(
    private val addContentUseCase: AddContentUseCase
) {
    @PostMapping("/content")
    fun postContent(content: Content) = addContentUseCase(content)
}