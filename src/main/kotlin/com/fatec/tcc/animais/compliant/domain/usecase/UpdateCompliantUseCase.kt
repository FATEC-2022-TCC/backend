package com.fatec.tcc.animais.compliant.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import com.fatec.tcc.animais.compliant.domain.model.UpdateCompliantRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.time.Instant
import java.util.*

@Component
class UpdateCompliantUseCase(
    private val repository: BaseRepository<Compliant>
) {
    operator fun invoke(request: UpdateCompliantRequest) = repository
        .find(request.id)
        ?.run {
            copy(
                resolution = request.resolution,
                resolutionFiles = request.resolutionFiles.map(::Base64),
                closed = request.closed,
                updated = Date.from(Instant.now())
            )
        }
        ?.run(repository::update)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}