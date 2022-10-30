package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.content.data.entity.ContentEntityProjection
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.mapper.ContentProjectionMapper
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentProjectionMapper: ContentProjectionMapper
) : DefaultSearchableRepository<ContentProjection, ContentEntityProjection, ContentEntityRepository, String>(
    repository = contentEntityRepository,
    projectionMapper = contentProjectionMapper,
    searchableMapper = { data, pageable -> searchProjection(data, pageable) }
), ContentProjectionRepository {
    override fun until(date: Date) = contentEntityRepository
        .findProjectionUntilDate(date, Sort.by("until").descending())
        .map(contentProjectionMapper::toDomain)
}