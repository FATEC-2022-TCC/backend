package com.fatec.tcc.animais.animal.data.repository

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.data.entity.AnimalEntityRepository
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.Mapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class AnimalRepositoryImpl(
    private val animalEntityRepository: AnimalEntityRepository,
    private val mapper: Mapper<AnimalEntity, Animal>
) : AnimalRepository {
    override fun all() = animalEntityRepository
        .findAll()
        .map(mapper::toDomain)

    override fun insert(animal: Animal) = animal
        .run(mapper::toEntity)
        .run(animalEntityRepository::save)
        .run(mapper::toDomain)

    override fun find(id: Long) = animalEntityRepository
        .findByIdOrNull(id)
        ?.run(mapper::toDomain)

    override fun find(name: String) = animalEntityRepository
        .findByName(name)
        ?.run(mapper::toDomain)

    override fun update(animal: Animal) = animal
        .run(mapper::toEntity)
        .run(animalEntityRepository::save)
        .run(mapper::toDomain)

    override fun delete(id: Long) = animalEntityRepository.deleteById(id)
}
