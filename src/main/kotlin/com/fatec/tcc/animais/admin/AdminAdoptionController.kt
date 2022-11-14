package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjectionRepositoryData
import com.fatec.tcc.animais.adoption.domain.model.NewAdoptionRequest
import com.fatec.tcc.animais.adoption.domain.model.UpdateAdoptionRequest
import com.fatec.tcc.animais.adoption.domain.usecase.AddAdoptionStatusUseCase
import com.fatec.tcc.animais.adoption.domain.usecase.AddAdoptionUseCase
import com.fatec.tcc.animais.adoption.domain.usecase.GetAdoptionUseCase
import com.fatec.tcc.animais.adoption.domain.usecase.SearchAdoptionProjectionUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/adoption")
class AdminAdoptionController(
    private val addAdoptionUseCase: AddAdoptionUseCase,
    private val addAdoptionStatusUseCase: AddAdoptionStatusUseCase,
    private val getAdoptionUseCase: GetAdoptionUseCase,
    private val searchAdoptionProjectionUseCase: SearchAdoptionProjectionUseCase
) {
    @PostMapping
    fun post(
        @RequestBody request: NewAdoptionRequest
    ) = addAdoptionUseCase(request)

    @PostMapping("/status")
    fun status(
        @RequestBody request: UpdateAdoptionRequest
    ) = addAdoptionStatusUseCase(request)

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getAdoptionUseCase(id)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "0") currentStatusCode: Int,
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "") gender: String,
        @RequestParam(defaultValue = "") size: String,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchAdoptionProjectionUseCase(
        AdoptionProjectionRepositoryData(
            currentStatusCode,
            text,
            gender,
            size
        ),
        page - 1
    )
}