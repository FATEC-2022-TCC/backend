package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.compliant.domain.model.NewCompliantRequest
import com.fatec.tcc.animais.compliant.domain.usecase.AddCompliantUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public/compliant")
class PublicCompliantController(
    private val addCompliantUseCase: AddCompliantUseCase
) {
    @PostMapping
    fun post(
        @RequestBody request: NewCompliantRequest
    ) = addCompliantUseCase(request)
}