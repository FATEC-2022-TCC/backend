package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.complaint.domain.model.NewComplaintRequest
import com.fatec.tcc.animais.complaint.domain.usecase.AddAnonymousComplaintUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/public/complaint")
class PublicComplaintController(
    private val addAnonymousComplaintUseCase: AddAnonymousComplaintUseCase
) {
    @PostMapping
    fun post(
        @RequestBody request: NewComplaintRequest
    ) = addAnonymousComplaintUseCase(request)
}