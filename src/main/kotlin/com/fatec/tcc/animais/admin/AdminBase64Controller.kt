package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.base64.domain.usecase.DeleteBase64UseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/base64")
class AdminBase64Controller(
    private val deleteBase64UseCase: DeleteBase64UseCase
) {
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = deleteBase64UseCase(id)
}