package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import com.fatec.tcc.animais.compliant.domain.usecase.SearchCompliantProjectionUseCase
import com.fatec.tcc.animais.content.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/compliant")
class AdminCompliantController(
    private val searchCompliantProjectionUseCase: SearchCompliantProjectionUseCase
) {
    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "false") closed: Boolean,
        @RequestParam(defaultValue = "1") page: Int
    ) = searchCompliantProjectionUseCase(
        CompliantProjectionRepositoryData(
            text, closed
        ),
        page - 1
    )
}