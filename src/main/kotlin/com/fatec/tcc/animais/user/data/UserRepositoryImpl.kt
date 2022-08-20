package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.user.domain.User
import com.fatec.tcc.animais.user.domain.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl(
    private val userEntityRepository: UserEntityRepository,
    private val mapper: Mapper<UserEntity, User>
) : UserRepository {
    override fun all() = userEntityRepository
        .findAll()
        .map(mapper::toDomain)

    override fun insert(user: User) = user
        .run(mapper::toEntity)
        .run(userEntityRepository::save)
        .run(mapper::toDomain)

    override fun find(id: Long) = userEntityRepository
        .findByIdOrNull(id)
        ?.run(mapper::toDomain)

    override fun update(user: User) = user
        .run(mapper::toEntity)
        .run(userEntityRepository::save)
        .run(mapper::toDomain)
}