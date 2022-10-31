package com.fatec.tcc.animais.compliant.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class GetCompliantUseCase(
    private val repository: BaseRepository<Compliant>
) {
    operator fun invoke(id: Long) =
        repository.find(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}