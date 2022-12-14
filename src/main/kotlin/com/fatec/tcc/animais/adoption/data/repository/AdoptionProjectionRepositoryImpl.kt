package com.fatec.tcc.animais.adoption.data.repository

import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityProjection
import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityRepository
import com.fatec.tcc.animais.adoption.data.mapper.AdoptionProjectionMapper
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjectionRepositoryData
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionProjectionRepository
import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.base.toPage
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository

@Repository
internal class AdoptionProjectionRepositoryImpl(
    private val repository: AdoptionEntityRepository,
    private val projectionMapper: AdoptionProjectionMapper
) : DefaultSearchableRepository<AdoptionProjection, AdoptionEntityProjection, AdoptionEntityRepository, AdoptionProjectionRepositoryData>(
    repository,
    projectionMapper,
    searchableMapper = { (currentStatusCode, text, gender, size), page ->
        search(
            text,
            gender,
            size,
            arrayListOf(currentStatusCode),
            page
        )
    }
), AdoptionProjectionRepository {
    override fun search(
        text: String,
        gender: String,
        size: String,
        statuses: List<Int>,
        page: Int,
        counter: Int
    ) = repository.search(
        text,
        gender,
        size,
        statuses,
        PageRequest.of(page, counter, Sort.Direction.DESC, "id")
    ).toPage(projectionMapper::toDomain)

    override fun search(
        createdBy: String,
        text: String,
        page: Int,
        size: Int
    ) = repository.search(
        createdBy,
        text,
        PageRequest.of(page, size, Sort.Direction.DESC, "id")
    ).toPage(projectionMapper::toDomain)
}