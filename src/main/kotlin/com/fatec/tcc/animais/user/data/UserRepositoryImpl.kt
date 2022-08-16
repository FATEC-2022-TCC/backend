package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.user.domain.User
import com.fatec.tcc.animais.user.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun all(): List<User> =
        userJpaRepository.findAll().map(UserMapper::toDomain)

    override fun insert(user: User) = user
        .run(UserMapper::toEntity)
        .run(userJpaRepository::save)
        .run(UserMapper::toDomain)
}