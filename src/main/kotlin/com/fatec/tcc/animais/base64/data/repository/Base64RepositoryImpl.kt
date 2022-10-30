package com.fatec.tcc.animais.base64.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import com.fatec.tcc.animais.base64.data.entity.Base64EntityRepository
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.base64.domain.model.Base64
import org.springframework.stereotype.Repository

@Repository
internal class Base64RepositoryImpl(
    base64EntityRepository: Base64EntityRepository,
    base64Mapper: Base64Mapper
) : DefaultRepository<Base64, Base64Entity, Base64EntityRepository>(
    repository = base64EntityRepository,
    repositoryMapper = base64Mapper
)