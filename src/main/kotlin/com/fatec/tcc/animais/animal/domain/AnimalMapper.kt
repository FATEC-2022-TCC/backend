package com.fatec.tcc.animais.animal.domain

import com.fatec.tcc.animais.animal.data.AnimalEntity
import com.fatec.tcc.animais.base.Mapper
import org.springframework.stereotype.Component

@Component
class AnimalMapper : Mapper<AnimalEntity, Animal> {
    override fun toEntity(domain: Animal) = domain.run {
        AnimalEntity(id, type, age)
    }

    override fun toDomain(entity: AnimalEntity) = entity.run {
        Animal(id, type, age)
    }
}