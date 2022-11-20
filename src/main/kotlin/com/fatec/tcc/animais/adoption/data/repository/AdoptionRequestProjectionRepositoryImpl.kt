package com.fatec.tcc.animais.adoption.data.repository

import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntityProjection
import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntityRepository
import com.fatec.tcc.animais.adoption.data.mapper.AdoptionRequestProjectionMapper
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjectionRepositoryData
import com.fatec.tcc.animais.adoption.domain.repository.AdoptionRequestProjectionRepository
import com.fatec.tcc.animais.base.DefaultSearchableRepository
import org.springframework.stereotype.Repository

@Repository
internal class AdoptionRequestProjectionRepositoryImpl(
    private val repository: AdoptionRequestEntityRepository,
    private val repositoryMapper: AdoptionRequestProjectionMapper
) : DefaultSearchableRepository
<
        AdoptionRequestProjection,
        AdoptionRequestEntityProjection,
        AdoptionRequestEntityRepository,
        AdoptionRequestProjectionRepositoryData,
>
(
    repository,
    repositoryMapper,
    searchableMapper = { data, page ->
        searchAdoptionProjectionByAdoptionId(
            data.id,
            data.text,
            data.currentStatusCode,
            page
        )
    }
), AdoptionRequestProjectionRepository {
    override fun getByAdoptionIdAndCreatedBy(adoptionId: Long, createdBy: String) = repository
        .getByAdoptionIdAndCreatedBy(adoptionId, createdBy)
        ?.run(repositoryMapper::toDomain)
}