package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.content.data.entity.ContentEntityProjection
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.mapper.ContentProjectionMapper
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
internal class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentProjectionMapper: ContentProjectionMapper
) : DefaultSearchableRepository<ContentProjection, ContentEntityProjection, ContentEntityRepository, String>(
    repository = contentEntityRepository,
    projectionMapper = contentProjectionMapper,
    searchableMapper = { text, pageable -> search(text, pageable) }
), ContentProjectionRepository {
    override fun until(instant: Instant) = contentEntityRepository
        .search(instant, Sort.by("until").descending())
        .map(contentProjectionMapper::toDomain)
}