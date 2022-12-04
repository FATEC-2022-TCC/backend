package com.fatec.tcc.animais.user.domain

import com.fatec.tcc.animais.complaint.domain.model.NewComplaintRequest
import com.fatec.tcc.animais.complaint.domain.usecase.AddComplaintUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/user/complaint")
class UserComplaintController(
    private val addComplaintUseCase: AddComplaintUseCase
) {
    @PostMapping
    fun post(
        @RequestBody request: NewComplaintRequest
    ) = addComplaintUseCase(request)
}