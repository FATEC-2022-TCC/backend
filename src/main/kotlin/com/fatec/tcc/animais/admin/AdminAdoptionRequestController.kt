package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjectionRepositoryData
import com.fatec.tcc.animais.adoption.domain.usecase.SearchAdoptionRequestProjectionUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/adoption/request")
class AdminAdoptionRequestController(
    private val searchAdoptionRequestProjectionUseCase: SearchAdoptionRequestProjectionUseCase
) {
    @PostMapping("/status")
    fun status() {

    }

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "0") id: Long,
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "0") currentStatusCode: Int,
        @RequestParam(defaultValue = "1") page: Int
    ) = searchAdoptionRequestProjectionUseCase(
        AdoptionRequestProjectionRepositoryData(
            id,
            text,
            currentStatusCode
        ),
        page - 1
    )
}