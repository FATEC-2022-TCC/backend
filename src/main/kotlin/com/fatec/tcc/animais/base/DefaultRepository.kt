package com.fatec.tcc.animais.base

import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

abstract class DefaultRepository<Domain : Any, Entity : Any, Repository : JpaRepository<Entity, Long>>(
    private val repository: Repository,
    private val repositoryMapper: Mapper<Entity, Domain>
) : BaseRepository<Domain>, PageableRepository<Domain> {
    override fun all() = repository
        .findAll()
        .map(repositoryMapper::toDomain)

    override fun insert(type: Domain) = type
        .run(repositoryMapper::toEntity)
        .run(repository::save)
        .run(repositoryMapper::toDomain)

    override fun find(id: Long) = repository
        .findByIdOrNull(id)
        ?.run(repositoryMapper::toDomain)

    override fun update(type: Domain) = type
        .run(repositoryMapper::toEntity)
        .run(repository::save)
        .run(repositoryMapper::toDomain)

    override fun delete(id: Long) = repository
        .deleteById(id)

    override fun all(page: Int, size: Int) = repository
        .findAll(PageRequest.of(page, size))
        .toPage(repositoryMapper::toDomain)
}