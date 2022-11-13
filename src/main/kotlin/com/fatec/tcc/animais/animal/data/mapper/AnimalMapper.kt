package com.fatec.tcc.animais.animal.data.mapper

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.category.data.mapper.CategoryMapper
import org.springframework.stereotype.Component

@Component
class AnimalMapper(
    private val categoryMapper: CategoryMapper
) : Mapper<AnimalEntity, Animal> {
    override fun toEntity(domain: Animal) = domain.run {
        AnimalEntity(
            id,
            picture,
            name,
            categoryMapper.toEntity(category),
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
            categoryMapper.toDomain(category),
            gender,
            age,
            size,
            about,
            created,
            createdBy,
            updated,
            updatedBy
        )
    }
}