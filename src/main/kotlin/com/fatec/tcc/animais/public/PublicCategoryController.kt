package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.category.domain.usecase.GetAllCategoryProjectionUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/public/category")
class PublicCategoryController(
    private val getAllCategoryProjectionUseCase: GetAllCategoryProjectionUseCase
) {
    @GetMapping("/project/all")
    fun all() = getAllCategoryProjectionUseCase()
}