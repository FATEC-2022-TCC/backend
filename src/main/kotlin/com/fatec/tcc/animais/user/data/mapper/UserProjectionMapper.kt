package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.user.data.entity.UserEntityProjection
import com.fatec.tcc.animais.user.domain.model.UserProjection
import org.springframework.stereotype.Component

@Component
class UserProjectionMapper : Mapper<UserEntityProjection, UserProjection> {
    override fun toEntity(domain: UserProjection) = domain.run {
        UserEntityProjection(
            id,
            username
        )
    }

    override fun toDomain(entity: UserEntityProjection) = entity.run {
        UserProjection(
            id,
            username
        )
    }
}