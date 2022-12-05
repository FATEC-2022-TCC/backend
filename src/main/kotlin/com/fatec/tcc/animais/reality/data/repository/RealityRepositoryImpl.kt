package com.fatec.tcc.animais.reality.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.reality.data.entity.RealityEntity
import com.fatec.tcc.animais.reality.data.entity.RealityEntityRepository
import com.fatec.tcc.animais.reality.data.mapper.RealityMapper
import com.fatec.tcc.animais.reality.domain.model.Reality
import org.springframework.stereotype.Repository

@Repository
internal class RealityRepositoryImpl(
    private val repository: RealityEntityRepository,
    private val repositoryMapper: RealityMapper
) : DefaultRepository<Reality, RealityEntity>(
    repository,
    repositoryMapper
)