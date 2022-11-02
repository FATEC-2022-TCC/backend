package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.compliant.domain.model.UpdateCompliantRequest
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import com.fatec.tcc.animais.compliant.domain.usecase.GetCompliantUseCase
import com.fatec.tcc.animais.compliant.domain.usecase.SearchCompliantProjectionUseCase
import com.fatec.tcc.animais.compliant.domain.usecase.UpdateCompliantUseCase
import com.fatec.tcc.animais.content.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/compliant")
class AdminCompliantController(
    private val getCompliantUseCase: GetCompliantUseCase,
    private val updateCompliantUseCase: UpdateCompliantUseCase,
    private val searchCompliantProjectionUseCase: SearchCompliantProjectionUseCase
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getCompliantUseCase(id)

    @PutMapping
    fun put(
        @RequestBody request: UpdateCompliantRequest
    ) = updateCompliantUseCase(request)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = searchCompliantProjectionUseCase(
        CompliantProjectionRepositoryData(
            text
        ),
        page - 1
    )
}