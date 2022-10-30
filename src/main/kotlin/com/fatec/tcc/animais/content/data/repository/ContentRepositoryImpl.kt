package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.content.data.entity.ContentEntity
import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.mapper.ContentMapper
import com.fatec.tcc.animais.content.domain.model.Content
import org.springframework.stereotype.Repository

@Repository
class ContentRepositoryImpl(
    contentEntityRepository: ContentEntityRepository,
    contentMapper: ContentMapper,
) : DefaultRepository<Content, ContentEntity, ContentEntityRepository>(
    jpaRepository = contentEntityRepository,
    jpaRepositoryMapper = contentMapper
)