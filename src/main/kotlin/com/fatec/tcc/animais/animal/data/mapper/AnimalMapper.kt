package com.fatec.tcc.animais.animal.data.mapper

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.Mapper
import org.springframework.stereotype.Component

@Component
class AnimalMapper : Mapper<AnimalEntity, Animal> {
    override fun toEntity(domain: Animal) = domain.run {
        AnimalEntity(
            id,
            picture,
            name,
            specie,
            gender,
            age,
            size,
            about
        )
    }

    override fun toDomain(entity: AnimalEntity) = entity.run {
        Animal(
            id,
            picture,
            name,
            specie,
            gender,
            age,
            size,
            about,
            created,
            updated,
        )
    }
}