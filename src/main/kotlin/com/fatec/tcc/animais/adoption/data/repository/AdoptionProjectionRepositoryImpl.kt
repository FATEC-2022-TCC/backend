package com.fatec.tcc.animais.adoption.data.repository

import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityProjection
import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityRepository
import com.fatec.tcc.animais.adoption.data.mapper.AdoptionProjectionMapper
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjectionRepositoryData
import com.fatec.tcc.animais.base.DefaultSearchableRepository
import org.springframework.stereotype.Repository

@Repository
internal class AdoptionProjectionRepositoryImpl(
    private val repository: AdoptionEntityRepository,
    private val projectionMapper: AdoptionProjectionMapper
) : DefaultSearchableRepository<AdoptionProjection, AdoptionEntityProjection, AdoptionEntityRepository, AdoptionProjectionRepositoryData>(
    repository,
    projectionMapper,
    searchableMapper = { data, page -> searchProjection(data.text, page) }
)