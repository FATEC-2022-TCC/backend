package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.reality.domain.model.NewRealityRequest
import com.fatec.tcc.animais.reality.domain.model.RealityProjectionRepositoryData
import com.fatec.tcc.animais.reality.domain.model.UpdateRealityRequest
import com.fatec.tcc.animais.reality.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/reality")
class AdminRealityController(
    private val getRealityUseCase: GetRealityUseCase,
    private val addRealityUseCase: AddRealityUseCase,
    private val updateRealityUseCase: UpdateRealityUseCase,
    private val searchRealityProjectionUseCase: SearchRealityProjectionUseCase,
    private val deleteRealityUseCase: DeleteRealityUseCase
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getRealityUseCase(id)

    @PostMapping
    fun post(
        @RequestBody request: NewRealityRequest
    ) = addRealityUseCase(request)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "true") isVisible: Boolean,
        @RequestParam(defaultValue = "1") page: Int,
    ) = searchRealityProjectionUseCase(
        RealityProjectionRepositoryData(text, isVisible),
        page - 1
    )

    @PutMapping
    fun put(
        @RequestBody request: UpdateRealityRequest
    ) = updateRealityUseCase(request)

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ) = deleteRealityUseCase(id)
}