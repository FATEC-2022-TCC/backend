package com.fatec.tcc.animais.animal.data.repository

import com.fatec.tcc.animais.animal.data.entity.AnimalEntityProjection
import com.fatec.tcc.animais.animal.data.entity.AnimalEntityRepository
import com.fatec.tcc.animais.animal.data.mapper.AnimalProjectionMapper
import com.fatec.tcc.animais.animal.domain.model.AnimalProjection
import com.fatec.tcc.animais.animal.domain.repository.AnimalProjectionRepositoryData
import com.fatec.tcc.animais.base.DefaultSearchableRepository
import org.springframework.stereotype.Repository

@Repository
internal class AnimalProjectionRepositoryImpl(
    repository: AnimalEntityRepository,
    projectionMapper: AnimalProjectionMapper
) : DefaultSearchableRepository<AnimalProjection, AnimalEntityProjection, AnimalEntityRepository, AnimalProjectionRepositoryData>(
    repository,
    projectionMapper,
    searchableMapper = { data, page -> findByName(data.text, data.userId, page) }
)