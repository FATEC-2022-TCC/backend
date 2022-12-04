package com.fatec.tcc.animais.reality.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.reality.data.repository.RealityEntity
import com.fatec.tcc.animais.reality.domain.model.Reality
import org.springframework.stereotype.Component

@Component
class RealityMapper(
    private val base64Mapper: Base64Mapper
) : Mapper<RealityEntity, Reality> {
    override fun toEntity(domain: Reality) = domain.run {
        RealityEntity(
            id,
            data,
            scale,
            title,
            description,
            images.map(base64Mapper::toEntity)
        )
    }

    override fun toDomain(entity: RealityEntity) = entity.run {
        Reality(
            id,
            data,
            scale,
            title,
            description,
            images.map(base64Mapper::toDomain) as ArrayList
        )
    }
}