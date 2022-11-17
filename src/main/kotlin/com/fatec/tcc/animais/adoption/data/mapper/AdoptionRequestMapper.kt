package com.fatec.tcc.animais.adoption.data.mapper

import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntity
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequest
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.status.data.mapper.StatusMapper
import org.springframework.stereotype.Component

@Component
class AdoptionRequestMapper(
    private val statusMapper: StatusMapper
) : Mapper<AdoptionRequestEntity, AdoptionRequest> {
    override fun toEntity(domain: AdoptionRequest) = domain.run {
        AdoptionRequestEntity(
            id,
            statuses.map(statusMapper::toEntity),
            currentStatusCode
        )
    }

    override fun toDomain(entity: AdoptionRequestEntity) = entity.run {
        AdoptionRequest(
            id,
            statuses.map(statusMapper::toDomain) as ArrayList,
            currentStatusCode,
            createdBy
        )
    }
}