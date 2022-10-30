package com.fatec.tcc.animais.base

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

abstract class DefaultSearchableRepository
<Domain : Any, Entity : Any, Repository : JpaRepository<*, Long>, Data : Any>
(
    private val repository: Repository,
    private val projectionMapper: ProjectionMapper<Entity, Domain>,
    private val searchableMapper: Repository.(Data, Pageable) -> Page<Entity>
) : SearchableRepository<Domain, Data> {
    override fun search(data: Data, page: Int, size: Int) = searchableMapper
        .invoke(repository, data, PageRequest.of(page, size))
        .toPage(projectionMapper::toDomain)
}