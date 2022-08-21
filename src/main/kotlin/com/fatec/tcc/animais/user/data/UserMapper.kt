package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.animal.data.AnimalEntity
import com.fatec.tcc.animais.animal.domain.Animal
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.roles.data.RoleEntity
import com.fatec.tcc.animais.roles.domain.Role
import com.fatec.tcc.animais.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val mapper: Mapper<RoleEntity, Role> ,
    private val mapperA: Mapper<AnimalEntity, Animal>
) : Mapper<UserEntity, User> {
    override fun toEntity(domain: User) = domain.run {
        UserEntity(id, name, email, roles.map(mapper::toEntity) , animals.map(mapperA::toEntity) )
    }

    override fun toDomain(entity: UserEntity) = entity.run {
        User(id, name, email, roles.map(mapper::toDomain), animals.map(mapperA::toDomain))
    }
}