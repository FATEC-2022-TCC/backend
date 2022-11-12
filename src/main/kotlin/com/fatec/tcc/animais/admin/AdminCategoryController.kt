package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.category.domain.model.AddCategoryRequest
import com.fatec.tcc.animais.category.domain.model.UpdateCategoryRequest
import com.fatec.tcc.animais.category.domain.usecase.AddCategoryUseCase
import com.fatec.tcc.animais.category.domain.usecase.SearchCategoryProjectionUseCase
import com.fatec.tcc.animais.category.domain.usecase.UpdateCategoryUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/category")
class AdminCategoryController(
    private val addCategoryUseCase: AddCategoryUseCase,
    private val searchCategoryProjectionUseCase: SearchCategoryProjectionUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase
) {
    @PostMapping
    fun post(
        @RequestBody request: AddCategoryRequest
    ) = addCategoryUseCase(request)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = searchCategoryProjectionUseCase(text, page - 1)

    @PutMapping
    fun put(
        @RequestBody request: UpdateCategoryRequest
    ) = updateCategoryUseCase(request)
}