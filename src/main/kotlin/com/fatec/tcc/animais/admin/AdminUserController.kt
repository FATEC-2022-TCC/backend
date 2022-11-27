package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.user.data.repository.UserProjectionRepositoryData
import com.fatec.tcc.animais.user.domain.model.UpdateUserPasswordRequest
import com.fatec.tcc.animais.user.domain.model.UpdateUserRequest
import com.fatec.tcc.animais.user.domain.usecase.GetUserProjectionUseCase
import com.fatec.tcc.animais.user.domain.usecase.GetUserUseCase
import com.fatec.tcc.animais.user.domain.usecase.UpdateUserPasswordUseCase
import com.fatec.tcc.animais.user.domain.usecase.UpdateUserUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/user")
class AdminUserController(
    private val getUserProjectionUseCase: GetUserProjectionUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val updateUserPasswordUseCase: UpdateUserPasswordUseCase
) {
    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "true") isActive: Boolean,
        @RequestParam(defaultValue = "1") page: Int,
    ) = getUserProjectionUseCase(
        UserProjectionRepositoryData(text, isActive),
        page - 1
    )

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getUserUseCase(id)

    @PutMapping
    fun put(
        @RequestBody request: UpdateUserRequest
    ) = updateUserUseCase(request)

    @PutMapping("/password")
    fun password(
        @RequestBody request: UpdateUserPasswordRequest
    ) = updateUserPasswordUseCase(request)
}