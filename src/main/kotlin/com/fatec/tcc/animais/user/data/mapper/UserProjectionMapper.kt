package com.fatec.tcc.animais.user.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.user.data.entity.UserEntityProjection
import com.fatec.tcc.animais.user.domain.model.UserProjection
import org.springframework.stereotype.Component

@Component
class UserProjectionMapper : ProjectionMapper<UserEntityProjection, UserProjection> {
    override fun toDomain(entity: UserEntityProjection) = entity.run {
        UserProjection(
            id,
            name,
            username,
            isActive,
            isValidated
        )
    }
}