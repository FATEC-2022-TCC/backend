package com.fatec.tcc.animais.adoption.data.repository

import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntity
import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntityRepository
import com.fatec.tcc.animais.adoption.data.mapper.AdoptionRequestMapper
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.base.DefaultRepository
import org.springframework.stereotype.Repository

@Repository
internal class AdoptionRequestRepositoryImpl(
    private val repository: AdoptionRequestEntityRepository,
    private val repositoryMapper: AdoptionRequestMapper
) : DefaultRepository<AdoptionRequest, AdoptionRequestEntity>(
    repository,
    repositoryMapper
)