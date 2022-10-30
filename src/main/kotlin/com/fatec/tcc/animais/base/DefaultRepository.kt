package com.fatec.tcc.animais.base

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

abstract class DefaultRepository<Domain : Any, Entity : Any, Repository : JpaRepository<Entity, Long>, Data : Any>(
    private val jpaRepository: Repository,
    private val jpaRepositoryMapper: Mapper<Entity, Domain>,
    private val searchableRepositoryMapper: Repository.(Data) -> Page<Entity>
) : BaseRepository<Domain>, PageableRepository<Domain>, SearchableRepository<Domain, Data> {
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

    override fun search(data: Data, page: Int, size: Int) = searchableRepositoryMapper
        .invoke(jpaRepository, data)
        .toPage(jpaRepositoryMapper::toDomain)
}