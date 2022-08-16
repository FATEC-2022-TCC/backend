package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.user.domain.User

object UserMapper {
    fun toEntity(user: User) = user.run {
        UserEntity(id, name, email)
    }

    fun toDomain(userEntity: UserEntity) = userEntity.run {
        User(id, name, email)
    }
}