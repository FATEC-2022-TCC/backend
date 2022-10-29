package com.fatec.tcc.animais.compliant.data.repository

import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityRepository
import com.fatec.tcc.animais.compliant.data.mapper.CompliantMapper
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import com.fatec.tcc.animais.compliant.domain.repository.CompliantRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CompliantRepositoryImpl(
    private val contentEntityRepository: CompliantEntityRepository,
    private val compliantMapper: CompliantMapper
) : CompliantRepository {
    override fun insert(type: Compliant) = type
        .run(compliantMapper::toEntity)
        .run(contentEntityRepository::save)
        .run(compliantMapper::toDomain)

    override fun all() = contentEntityRepository
        .findAll()
        .map(compliantMapper::toDomain)

    override fun delete(id: Long) = contentEntityRepository
        .deleteById(id)

    override fun find(id: Long) = contentEntityRepository
        .findByIdOrNull(id)
        ?.run(compliantMapper::toDomain)

    override fun update(type: Compliant) = type
        .run(compliantMapper::toEntity)
        .run(contentEntityRepository::save)
        .run(compliantMapper::toDomain)
}