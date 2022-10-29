package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.base.toPage
import com.fatec.tcc.animais.content.data.entity.ContentEntityProjection
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentProjectionMapper: ProjectionMapper<ContentEntityProjection, ContentProjection>
) : ContentProjectionRepository {
    override fun until(date: Date) = contentEntityRepository
        .findProjectionUntilDate(date, Sort.by("until").descending())
        .map(contentProjectionMapper::toDomain)

    override fun search(data: String, page: Int, perPage: Int) = contentEntityRepository
        .searchProjection(data, PageRequest.of(page, perPage))
        .toPage(contentProjectionMapper::toDomain)
}