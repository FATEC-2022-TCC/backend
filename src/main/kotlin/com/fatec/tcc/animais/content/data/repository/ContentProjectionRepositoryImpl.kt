package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.entity.ContentProjectionEntity
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentProjectionMapper: ProjectionMapper<ContentProjectionEntity, ContentProjection>
) : ContentProjectionRepository {
    override fun all() = contentEntityRepository
        .findProjection()
        .map(contentProjectionMapper::toDomain)

    override fun all(date: Date, vararg sorts: String) = contentEntityRepository
        .findProjectionUntilDate(date, Sort.by(*sorts).descending())
        .map(contentProjectionMapper::toDomain)
}