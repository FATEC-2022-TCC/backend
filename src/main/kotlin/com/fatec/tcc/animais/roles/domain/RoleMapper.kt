package com.fatec.tcc.animais.roles.domain

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.roles.data.RoleEntity
import org.springframework.stereotype.Component

@Component
class RoleMapper : Mapper<RoleEntity, Role> {
    override fun toEntity(domain: Role) = domain.run {
        RoleEntity(id, number)
    }

    override fun toDomain(entity: RoleEntity) = entity.run {
        Role(id, number)
    }
}