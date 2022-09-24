package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.roles.data.RoleEntity
import com.fatec.tcc.animais.roles.domain.Role
import com.fatec.tcc.animais.user.data.entity.UserEntity
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val roleMapper: Mapper<RoleEntity, Role>,
    private val animalMapper: Mapper<AnimalEntity, Animal>
) : Mapper<UserEntity, User> {
    override fun toEntity(domain: User) = domain.run {
        UserEntity(
            id,
            name,
            username,
            password,
            email,
            roles.map(roleMapper::toEntity),
            animals.map(animalMapper::toEntity)
        )
    }

    override fun toDomain(entity: UserEntity) = entity.run {
        User(
            id,
            name,
            username,
            password,
            email,
            roles.map(roleMapper::toDomain),
            animals.map(animalMapper::toDomain)
        )
    }
}