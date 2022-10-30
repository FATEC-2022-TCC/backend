package com.fatec.tcc.animais.base

import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

abstract class DefaultSearchableRepository
<Domain : Any, Entity : Any, Projection : Any, Repository : JpaRepository<Entity, Long>, Data : Any>
(
    private val repository: Repository,
    private val projectionMapper: ProjectionMapper<Projection, Domain>,
    private val searchableMapper: Repository.(Data, Int, Int) -> Page<Projection>
) : SearchableRepository<Domain, Data> {
    override fun search(data: Data, page: Int, size: Int) = searchableMapper
        .invoke(repository, data, page, size)
        .toPage(projectionMapper::toDomain)
}