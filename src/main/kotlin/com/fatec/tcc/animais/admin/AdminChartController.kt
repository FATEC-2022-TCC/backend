package com.fatec.tcc.animais.admin

import com.fatec.tcc.animais.chart.usecase.GetComplaintDataChartUseCase
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin/chart")
class AdminChartController(
    private val getComplaintDataChartUseCase: GetComplaintDataChartUseCase
) {
    @GetMapping("/complaint")
    fun complaint() = getComplaintDataChartUseCase()

    @GetMapping("/adoption")
    fun adoption() {

    }
}