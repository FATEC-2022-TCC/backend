package com.fatec.tcc.animais.animal.data.repository

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.animal.data.entity.AnimalEntityRepository
import com.fatec.tcc.animais.animal.data.mapper.AnimalMapper
import com.fatec.tcc.animais.animal.domain.model.Animal
import com.fatec.tcc.animais.animal.domain.repository.AnimalRepository
import com.fatec.tcc.animais.base.DefaultRepository
import org.springframework.stereotype.Repository

@Repository
internal class AnimalRepositoryImpl(
    private val repository: AnimalEntityRepository,
    private val repositoryMapper: AnimalMapper
) : DefaultRepository<Animal, AnimalEntity>(
    repository,
    repositoryMapper
), AnimalRepository {
    override fun findByUserIdAndAnimalId(userId: Long, animalId: Long) = repository
        .findByUserIdAndAnimalId(userId, animalId)
        ?.run(repositoryMapper::toDomain)
}