package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.entity.ContentProjectionEntity
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Repository

@Repository
class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentEntityProjectionMapper: ProjectionMapper<ContentProjectionEntity, ContentProjection>
) : ContentProjectionRepository {
    override fun all() = contentEntityRepository
        .findProjection()
        .map(contentEntityProjectionMapper::toDomain)
}