package com.fatec.tcc.animais.adoption.data.mapper

import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntity
import com.fatec.tcc.animais.adoption.domain.model.Adoption
import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.status.data.mapper.StatusMapper
import org.springframework.stereotype.Component

@Component
class AdoptionMapper(
    private val base64Mapper: Base64Mapper,
    private val statusMapper: StatusMapper,
    private val adoptionRequestMapper: AdoptionRequestMapper,
) : Mapper<AdoptionEntity, Adoption> {
    override fun toEntity(domain: Adoption) = domain.run {
        AdoptionEntity(
            id,
            name,
            description,
            picture,
            images.map(base64Mapper::toEntity),
            statuses.map(statusMapper::toEntity),
            currentStatusCode,
            requests.map(adoptionRequestMapper::toEntity)
        )
    }

    override fun toDomain(entity: AdoptionEntity) = entity.run {
        Adoption(
            id,
            name,
            description,
            picture,
            images.map(base64Mapper::toDomain) as ArrayList,
            statuses.map(statusMapper::toDomain) as ArrayList,
            currentStatusCode,
            requests.map(adoptionRequestMapper::toDomain) as ArrayList
        )
    }
}