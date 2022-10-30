package com.fatec.tcc.animais.compliant.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntity
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityRepository
import com.fatec.tcc.animais.compliant.data.mapper.CompliantMapper
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import org.springframework.stereotype.Repository

@Repository
class CompliantRepositoryImpl(
    contentEntityRepository: CompliantEntityRepository,
    compliantMapper: CompliantMapper
) : DefaultRepository<Compliant, CompliantEntity, CompliantEntityRepository>(
    repository = contentEntityRepository,
    repositoryMapper = compliantMapper
)