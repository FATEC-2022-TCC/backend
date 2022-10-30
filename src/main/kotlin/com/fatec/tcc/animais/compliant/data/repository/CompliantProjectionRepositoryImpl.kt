package com.fatec.tcc.animais.compliant.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntity
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityProjection
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityRepository
import com.fatec.tcc.animais.compliant.data.mapper.CompliantProjectionMapper
import com.fatec.tcc.animais.compliant.domain.model.CompliantProjection
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepositoryData
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository

@Repository
class CompliantProjectionRepositoryImpl(
    compliantEntityRepository: CompliantEntityRepository,
    compliantProjectionMapper: CompliantProjectionMapper
) : DefaultSearchableRepository<CompliantProjection, CompliantEntity, CompliantEntityProjection, CompliantEntityRepository, CompliantProjectionRepositoryData>(
    repository = compliantEntityRepository,
    projectionMapper = compliantProjectionMapper,
    searchableMapper = { data, page, size -> searchProjection(data.text, data.closed, PageRequest.of(page, size)) }
)