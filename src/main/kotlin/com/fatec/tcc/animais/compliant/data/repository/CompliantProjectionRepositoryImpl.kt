package com.fatec.tcc.animais.compliant.data.repository

import com.fatec.tcc.animais.base.toPage
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityRepository
import com.fatec.tcc.animais.compliant.data.mapper.CompliantProjectionMapper
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepository
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository

@Repository
class CompliantProjectionRepositoryImpl(
    private val compliantEntityRepository: CompliantEntityRepository,
    private val compliantProjectionMapper: CompliantProjectionMapper
) : CompliantProjectionRepository {
    override fun search(data: CompliantProjectionRepositoryData, page: Int, size: Int) = compliantEntityRepository
        .searchProjection(data.text, data.closed, PageRequest.of(page, size))
        .toPage(compliantProjectionMapper::toDomain)
}