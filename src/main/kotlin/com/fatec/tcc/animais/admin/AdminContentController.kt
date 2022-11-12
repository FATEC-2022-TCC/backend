package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.content.domain.model.NewContentRequest
import com.fatec.tcc.animais.content.domain.model.UpdateContentRequest
import com.fatec.tcc.animais.content.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/content")
class AdminContentController(
    private val addContentUseCase: AddContentUseCase,
    private val getPaginatedContentUseCase: GetPaginatedContentUseCase,
    private val getContentUseCase: GetContentUseCase,
    private val updateContentUseCase: UpdateContentUseCase,
    private val deleteContentUseCase: DeleteContentUseCase,
    private val searchContentProjectionUseCase: SearchContentProjectionUseCase,
) {
    @PostMapping
    fun post(
        @RequestBody request: NewContentRequest
    ) = addContentUseCase(request)

    @GetMapping
    fun get() =
        getPaginatedContentUseCase()

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getContentUseCase(id)

    @PutMapping
    fun put(
        @RequestBody request: UpdateContentRequest
    ) = updateContentUseCase(request)

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ) = deleteContentUseCase(id)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchContentProjectionUseCase(text, page - 1)
}