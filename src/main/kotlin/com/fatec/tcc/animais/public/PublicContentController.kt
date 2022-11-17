package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionInEvidenceUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentUseCase
import com.fatec.tcc.animais.content.domain.usecase.SearchContentProjectionUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public/content")
class PublicContentController(
    private val getContentProjectionInEvidenceUseCase: GetContentProjectionInEvidenceUseCase,
    private val getContentUseCase: GetContentUseCase,
    private val searchContentProjectionUseCase: SearchContentProjectionUseCase
) {
    @GetMapping("/projection/evidence")
    fun projectionInEvidence() = getContentProjectionInEvidenceUseCase()

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchContentProjectionUseCase(
        text,
        page - 1
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getContentUseCase(id)
}