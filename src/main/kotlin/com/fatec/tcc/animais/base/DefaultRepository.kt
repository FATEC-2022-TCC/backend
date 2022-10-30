package com.fatec.tcc.animais.base

import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

abstract class DefaultRepository<Domain : Any, Entity : Any, Repository : JpaRepository<Entity, Long>>(
    private val jpaRepository: Repository,
    private val jpaRepositoryMapper: Mapper<Entity, Domain>
) : BaseRepository<Domain>, PageableRepository<Domain> {
    override fun all() = jpaRepository
        .findAll()
        .map(jpaRepositoryMapper::toDomain)

    override fun insert(type: Domain) = type
        .run(jpaRepositoryMapper::toEntity)
        .run(jpaRepository::save)
        .run(jpaRepositoryMapper::toDomain)

    override fun find(id: Long) = jpaRepository
        .findByIdOrNull(id)
        ?.run(jpaRepositoryMapper::toDomain)

    override fun update(type: Domain) = type
        .run(jpaRepositoryMapper::toEntity)
        .run(jpaRepository::save)
        .run(jpaRepositoryMapper::toDomain)

    override fun delete(id: Long) = jpaRepository
        .deleteById(id)

    override fun all(page: Int, size: Int) = jpaRepository
        .findAll(PageRequest.of(page, size))
        .toPage(jpaRepositoryMapper::toDomain)
}