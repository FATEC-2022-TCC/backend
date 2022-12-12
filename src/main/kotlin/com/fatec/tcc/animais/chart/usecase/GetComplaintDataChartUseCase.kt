package com.fatec.tcc.animais.chart.usecase

import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.chart.model.ComplaintDataChart
import com.fatec.tcc.animais.complaint.domain.constant.ComplaintStatusEnum
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintRepository

@UseCase
class GetComplaintDataChartUseCase(
    private val complaintRepository: ComplaintRepository
) {
    operator fun invoke(): List<ComplaintDataChart> {
        val values = ComplaintStatusEnum.values()
        val colors = mapOf(
            ComplaintStatusEnum.CREATED.code to "#F00",
            ComplaintStatusEnum.PAUSED.code to "#00F",
            ComplaintStatusEnum.RUNNING.code to "#0F0"
        )
        return complaintRepository.search(
            arrayListOf(
                ComplaintStatusEnum.CREATED,
                ComplaintStatusEnum.PAUSED,
                ComplaintStatusEnum.RUNNING
            ).map(ComplaintStatusEnum::code)
        ).groupBy {
            it.currentStatusCode
        }.map { (key, value) ->
            ComplaintDataChart(
                values[key].description,
                colors[key] ?: "#FFF",
                value.size,
                value
            )
        }
    }
}