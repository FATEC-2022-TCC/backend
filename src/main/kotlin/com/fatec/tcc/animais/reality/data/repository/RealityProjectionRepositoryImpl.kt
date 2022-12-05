package com.fatec.tcc.animais.reality.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.reality.data.entity.RealityEntityProjection
import com.fatec.tcc.animais.reality.data.entity.RealityEntityRepository
import com.fatec.tcc.animais.reality.data.mapper.RealityProjectionMapper
import com.fatec.tcc.animais.reality.domain.model.RealityProjection
import com.fatec.tcc.animais.reality.domain.model.RealityProjectionRepositoryData
import org.springframework.stereotype.Repository

@Repository
internal class RealityProjectionRepositoryImpl(
    private val repository: RealityEntityRepository,
    private val repositoryMapper: RealityProjectionMapper
) : DefaultSearchableRepository<RealityProjection, RealityEntityProjection, RealityEntityRepository, RealityProjectionRepositoryData>(
    repository,
    repositoryMapper,
    searchableMapper = { data, page -> search(data.text, data.isVisible, page) }
)