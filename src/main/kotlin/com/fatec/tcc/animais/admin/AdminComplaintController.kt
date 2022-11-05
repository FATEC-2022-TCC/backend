package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.complaint.domain.model.UpdateComplaintRequest
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintProjectionRepositoryData
import com.fatec.tcc.animais.complaint.domain.usecase.AddComplaintStatusUseCase
import com.fatec.tcc.animais.complaint.domain.usecase.GetComplaintUseCase
import com.fatec.tcc.animais.complaint.domain.usecase.SearchComplaintProjectionUseCase
import com.fatec.tcc.animais.content.domain.usecase.*
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/complaint")
class AdminComplaintController(
    private val getComplaintUseCase: GetComplaintUseCase,
    private val addComplaintStatusUseCase: AddComplaintStatusUseCase,
    private val searchComplaintProjectionUseCase: SearchComplaintProjectionUseCase
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = getComplaintUseCase(id)

    @PostMapping("/status")
    fun post(
        @RequestBody request: UpdateComplaintRequest
    ) = addComplaintStatusUseCase(request)

    @GetMapping("/projection")
    fun project(
        @RequestParam(defaultValue = "") text: String,
        @RequestParam(defaultValue = "1") page: Int
    ) = searchComplaintProjectionUseCase(
        ComplaintProjectionRepositoryData(
            text
        ),
        page - 1
    )
}