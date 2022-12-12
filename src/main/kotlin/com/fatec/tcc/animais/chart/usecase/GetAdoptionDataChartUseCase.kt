package com.fatec.tcc.animais.chart.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionRequestStatusEnum
import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRepository
import com.fatec.tcc.animais.base.UseCase
import com.fatec.tcc.animais.chart.model.AdoptionDataChart
import java.security.SecureRandom

@UseCase
class GetAdoptionDataChartUseCase(
    private val adoptionRepository: AdoptionRepository
) {
    private companion object {
        private val random = SecureRandom()
        private fun getColor(): String {
            val number = random.nextInt(0xFFFFFF)
            val hex = Integer.toHexString(number)
            return "#$hex"
        }
        private val adoptionRequestStatus = arrayOf(
            AdoptionRequestStatusEnum.REQUESTED,
            AdoptionRequestStatusEnum.PAUSED,
            AdoptionRequestStatusEnum.ENQUEUED
        ).map(AdoptionRequestStatusEnum::code)
    }

    operator fun invoke() = adoptionRepository.findByCurrentStatusCode(
        AdoptionStatusEnum.VISIBLE.code
    ).filter {
        it.requests.any {
            adoptionRequestStatus.contains(it.currentStatusCode)
        }
    }.map {
        AdoptionDataChart(
            it.id,
            it.name,
            getColor(),
            it.requests.count {
                adoptionRequestStatus.contains(it.currentStatusCode)
            }
        )
    }
}