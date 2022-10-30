package com.fatec.tcc.animais.user.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.user.data.entity.UserEntity
import com.fatec.tcc.animais.user.data.entity.UserEntityRepository
import com.fatec.tcc.animais.user.data.mapper.UserMapper
import com.fatec.tcc.animais.user.domain.model.User
import com.fatec.tcc.animais.user.domain.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userEntityRepository: UserEntityRepository,
    private val userEntityRepositoryMapper: UserMapper
) : DefaultRepository<User, UserEntity, UserEntityRepository>(
    repository = userEntityRepository,
    repositoryMapper = userEntityRepositoryMapper
), UserRepository {
    override fun findByUsername(username: String) = userEntityRepository
        .findByUsername(username)
        ?.run(userEntityRepositoryMapper::toDomain)
}