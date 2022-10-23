package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.data.mapper.ContentMapper
import com.fatec.tcc.animais.content.domain.model.Content
import com.fatec.tcc.animais.content.domain.repository.ContentRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ContentRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository,
    private val contentMapper: ContentMapper
) : ContentRepository {
    override fun insert(content: Content) = content
        .run(contentMapper::toEntity)
        .run(contentEntityRepository::save)
        .run(contentMapper::toDomain)

    override fun until(date: Date) = contentEntityRepository
        .findUntilDate(date)
        .map(contentMapper::toDomain)

    override fun all() = contentEntityRepository
        .findAll()
        .map(contentMapper::toDomain)

    override fun delete(id: Long) = contentEntityRepository
        .deleteById(id)
}