package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.adoption.domain.usecase.GetPublicAdoptionUseCase
import com.fatec.tcc.animais.adoption.domain.usecase.SearchPublicAdoptionProjectionUseCase
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/public/adoption")
class PublicAdoptionController(
    private val searchPublicAdoptionProjectionUseCase: SearchPublicAdoptionProjectionUseCase,
    private val getPublicAdoptionUseCase: GetPublicAdoptionUseCase
) {
    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "") gender: String,
        @RequestParam(defaultValue = "") size: String,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchPublicAdoptionProjectionUseCase(
        text,
        gender,
        size,
        page - 1
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getPublicAdoptionUseCase(id)
}