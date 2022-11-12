package com.fatec.tcc.animais.base64.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base64.domain.model.Base64
import org.springframework.stereotype.Component

@Component
class DeleteBase64UseCase(
    private val repository: BaseRepository<Base64>
) {
    operator fun invoke(id: Long) = repository.delete(id)
}