package com.fatec.tcc.animais.content.data.repository

import com.fatec.tcc.animais.content.data.entity.ContentEntityRepository
import com.fatec.tcc.animais.content.domain.repository.ContentProjectionRepository
import org.springframework.stereotype.Repository

@Repository
class ContentProjectionRepositoryImpl(
    private val contentEntityRepository: ContentEntityRepository
) : ContentProjectionRepository {
    override fun all() = contentEntityRepository.findProjection()
}