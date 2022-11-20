package com.fatec.tcc.animais.adoption.data.repository

import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntity
import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityRepository
import com.fatec.tcc.animais.adoption.data.mapper.AdoptionMapper
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRepository
import com.fatec.tcc.animais.base.DefaultRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository

@Repository
internal class AdoptionRepositoryImpl(
    private val repository: AdoptionEntityRepository,
    private val repositoryMapper: AdoptionMapper
) : DefaultRepository<Adoption, AdoptionEntity>(
    repository,
    repositoryMapper
), AdoptionRepository {
    override fun findByCreatedByAndId(id: Long, createdBy: String) = repository
        .findByCreatedByAndId(id, createdBy)
        ?.run(repositoryMapper::toDomain)
}