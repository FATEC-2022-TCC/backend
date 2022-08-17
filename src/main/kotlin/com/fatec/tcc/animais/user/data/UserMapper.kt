package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.roles.data.RoleEntity
import com.fatec.tcc.animais.roles.domain.Role
import com.fatec.tcc.animais.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val mapper: Mapper<RoleEntity, Role>
) : Mapper<UserEntity, User> {
    override fun toEntity(domain: User) = domain.run {
        UserEntity(id, name, email, roles.map(mapper::toEntity))
    }

    override fun toDomain(entity: UserEntity) = entity.run {
        User(id, name, email, roles.map(mapper::toDomain))
    }
}