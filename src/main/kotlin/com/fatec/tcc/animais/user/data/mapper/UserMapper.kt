package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.animal.data.mapper.AnimalMapper
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.user.data.entity.UserEntity
import com.fatec.tcc.animais.user.domain.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val animalMapper: AnimalMapper,
    private val privateInfoMapper: PrivateInfoMapper
) : Mapper<UserEntity, User> {
    override fun toEntity(domain: User) = domain.run {
        UserEntity(
            id,
            name,
            username,
            password,
            authority,
            isActive,
            isValidated,
            privateInfoMapper.toEntity(privateInfo),
            animals.map(animalMapper::toEntity)
        )
    }

    override fun toDomain(entity: UserEntity) = entity.run {
        User(
            id,
            name,
            username,
            password,
            authority,
            isActive,
            isValidated,
            privateInfoMapper.toDomain(privateInfo),
            animals.map(animalMapper::toDomain) as ArrayList<Animal>,
            created,
            createdBy,
            updated,
            updatedBy
        )
    }
}