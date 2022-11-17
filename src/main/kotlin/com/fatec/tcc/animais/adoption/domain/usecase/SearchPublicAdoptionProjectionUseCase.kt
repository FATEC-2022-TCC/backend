package com.fatec.tcc.animais.adoption.domain.usecase

import com.fatec.tcc.animais.adoption.domain.constant.AdoptionStatusEnum
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionProjectionRepository
import com.fatec.tcc.animais.base.UseCase
import org.springframework.beans.factory.annotation.Value

@UseCase
class SearchPublicAdoptionProjectionUseCase(
    private val repository: AdoptionProjectionRepository,
    @Value("\${custom.pagination.counter}")
    private val paginationCounter: Int
) {
    operator fun invoke(
        text: String,
        gender: String,
        size: String,
        page: Int,
    ) = repository.searchProjection(
        text,
        gender,
        size,
        arrayListOf(AdoptionStatusEnum.VISIBLE.code),
        page,
        paginationCounter
    )
}