package com.fatec.tcc.animais.animal.data.repository

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.data.entity.AnimalEntityRepository
import com.fatec.tcc.animais.animal.data.mapper.AnimalMapper
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.base.DefaultRepository
import org.springframework.stereotype.Service

@Service
class AnimalRepositoryImpl(
    animalEntityRepository: AnimalEntityRepository,
    animalMapper: AnimalMapper
) : DefaultRepository<Animal, AnimalEntity, AnimalEntityRepository>(
    repository = animalEntityRepository,
    repositoryMapper = animalMapper
)
