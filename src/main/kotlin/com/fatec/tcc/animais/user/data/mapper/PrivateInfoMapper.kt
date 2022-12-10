package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.user.data.entity.PrivateInfoEntity
import com.fatec.tcc.animais.user.domain.model.PrivateInfo
import org.springframework.stereotype.Component

@Component
class PrivateInfoMapper : Mapper<PrivateInfoEntity, PrivateInfo> {
    override fun toEntity(domain: PrivateInfo) = domain.run {
        PrivateInfoEntity(
            email,
            telephony,
            identification,
            address,
            picture,
        )
    }

    override fun toDomain(entity: PrivateInfoEntity) = entity.run {
        PrivateInfo(
            email,
            telephony,
            identification,
            address,
            picture,
        )
    }
}