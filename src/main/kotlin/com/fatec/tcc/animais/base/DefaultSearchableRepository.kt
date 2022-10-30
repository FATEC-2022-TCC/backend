package com.fatec.tcc.animais.base

import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

abstract class DefaultSearchableRepository<Domain : Any, Entity : Any, Repository : JpaRepository<Entity, Long>, Data : Any>(
    private val jpaRepository: Repository,
    private val jpaRepositoryMapper: Mapper<Entity, Domain>,
    private val searchableRepositoryMapper: Repository.(Data) -> Page<Entity>
) : DefaultRepository<Domain, Entity, Repository>(
    jpaRepository = jpaRepository,
    jpaRepositoryMapper = jpaRepositoryMapper
), SearchableRepository<Domain, Data> {
    override fun search(data: Data, page: Int, size: Int) = searchableRepositoryMapper
        .invoke(jpaRepository, data)
        .toPage(jpaRepositoryMapper::toDomain)
}