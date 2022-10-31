package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionInEvidenceUseCase
import com.fatec.tcc.animais.content.domain.usecase.GetContentUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public/content")
class PublicContentController(
    private val getContentProjectionInEvidenceUseCase: GetContentProjectionInEvidenceUseCase,
    private val getContentUseCase: GetContentUseCase
) {
    @GetMapping("/projection/evidence")
    fun projectionInEvidence() = getContentProjectionInEvidenceUseCase()

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getContentUseCase(id)
}