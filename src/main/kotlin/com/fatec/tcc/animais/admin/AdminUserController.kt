package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.user.data.repository.UserProjectionRepositoryData
import com.fatec.tcc.animais.user.domain.model.AdminUpdateUserPasswordRequest
import com.fatec.tcc.animais.user.domain.model.AdminUpdateUserRequest
import com.fatec.tcc.animais.user.domain.usecase.GetUserProjectionUseCase
import com.fatec.tcc.animais.user.domain.usecase.GetUserUseCase
import com.fatec.tcc.animais.user.domain.usecase.AdminUpdateUserPasswordUseCase
import com.fatec.tcc.animais.user.domain.usecase.AdminUpdateUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/user")
class AdminUserController(
    private val getUserProjectionUseCase: GetUserProjectionUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val adminUpdateUserUseCase: AdminUpdateUserUseCase,
    private val adminUpdateUserPasswordUseCase: AdminUpdateUserPasswordUseCase
) {
    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "true") isActive: Boolean,
        @RequestParam(defaultValue = "true") isValidated: Boolean,
        @RequestParam(defaultValue = "1") page: Int,
    ) = getUserProjectionUseCase(
        UserProjectionRepositoryData(text, isActive, isValidated),
        page - 1
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getUserUseCase(id)

    @PutMapping
    fun put(
        @RequestBody request: AdminUpdateUserRequest
    ) = adminUpdateUserUseCase(request)

    @PutMapping("/password")
    fun password(
        @RequestBody request: AdminUpdateUserPasswordRequest
    ) = adminUpdateUserPasswordUseCase(request)
}