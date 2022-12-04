package com.fatec.tcc.animais.user.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.user.data.entity.UserEntityProjection
import com.fatec.tcc.animais.user.data.entity.UserEntityRepository
import com.fatec.tcc.animais.user.data.mapper.UserProjectionMapper
import com.fatec.tcc.animais.user.domain.model.UserProjection
import org.springframework.stereotype.Repository

@Repository
internal class UserProjectionRepositoryImpl(
    private val repository: UserEntityRepository,
    private val repositoryMapper: UserProjectionMapper
) : DefaultSearchableRepository<UserProjection, UserEntityProjection, UserEntityRepository, UserProjectionRepositoryData>(
    repository,
    repositoryMapper,
    { data, page -> search(data.text, data.isActive, data.isValidated, page) }
)