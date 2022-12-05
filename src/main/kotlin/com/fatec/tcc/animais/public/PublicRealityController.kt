package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.reality.domain.model.RealityProjectionRepositoryData
import com.fatec.tcc.animais.reality.domain.usecase.GetRealityUseCase
import com.fatec.tcc.animais.reality.domain.usecase.SearchRealityProjectionUseCase
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/public/reality")
// the reality can be whatever i want
// have you ever questioned the nature of your reality
class PublicRealityController(
    private val searchRealityProjectionUseCase: SearchRealityProjectionUseCase,
    private val getRealityUseCase: GetRealityUseCase
) {
    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchRealityProjectionUseCase(
        RealityProjectionRepositoryData(text, true),
        page - 1
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getRealityUseCase(id)
}