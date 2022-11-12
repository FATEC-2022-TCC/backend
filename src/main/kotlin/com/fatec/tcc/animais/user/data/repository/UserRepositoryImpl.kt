package com.fatec.tcc.animais.user.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.user.data.entity.UserEntity
import com.fatec.tcc.animais.user.data.entity.UserEntityRepository
import com.fatec.tcc.animais.user.data.mapper.UserMapper
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryImpl(
    private val repository: UserEntityRepository,
    private val repositoryMapper: UserMapper
) : DefaultRepository<User, UserEntity>(
    repository,
    repositoryMapper
), UserRepository {
    override fun findByUsername(username: String) = repository
        .findByUsername(username)
        ?.run(repositoryMapper::toDomain)
}