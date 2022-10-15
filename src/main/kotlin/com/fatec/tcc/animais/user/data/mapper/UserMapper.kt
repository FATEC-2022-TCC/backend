package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.user.data.entity.UserEntity
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val animalMapper: Mapper<AnimalEntity, Animal>
) : Mapper<UserEntity, User> {
    override fun toEntity(domain: User) = domain.run {
        UserEntity(
            id,
            name,
            username,
            password,
            email,
            authority,
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
            authority,
            animals.map(animalMapper::toDomain)
        )
    }
}