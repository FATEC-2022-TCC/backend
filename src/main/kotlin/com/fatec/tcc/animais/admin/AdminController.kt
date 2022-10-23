package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.model.NewContentRequest
import com.fatec.tcc.animais.content.domain.model.UpdateContentRequest
import com.fatec.tcc.animais.content.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin")
class AdminController(
    private val addContentUseCase: AddContentUseCase,
    private val getPaginatedContentUseCase: GetPaginatedContentUseCase,
    private val getContentUseCase: GetContentUseCase,
    private val updateContentUseCase: UpdateContentUseCase,
    private val removeContentUseCase: RemoveContentUseCase,
    private val getPaginatedContentProjectionUseCase: GetPaginatedContentProjectionUseCase,
) {
    @PostMapping("/content")
    fun postContent(
        @RequestBody request: NewContentRequest
    ) = addContentUseCase(request)

    @GetMapping("/content")
    fun getContent() =
        getPaginatedContentUseCase()

    @GetMapping("/content/{id}")
    fun getContent(
        @PathVariable id: Long
    ) = getContentUseCase(id)

    @PutMapping("/content")
    fun updateContent(
        @RequestBody request: UpdateContentRequest
    ) = updateContentUseCase(request)

    @DeleteMapping("/content/{id}")
    fun deleteContent(
        @PathVariable id: Long
    ) = removeContentUseCase(id)

    @GetMapping("/content/projection")
    fun getContentProjection() =
        getPaginatedContentProjectionUseCase()
}