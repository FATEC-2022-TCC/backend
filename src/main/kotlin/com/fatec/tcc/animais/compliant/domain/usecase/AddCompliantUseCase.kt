package com.fatec.tcc.animais.compliant.domain.usecase

import com.fatec.tcc.animais.base.BaseRepository
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import com.fatec.tcc.animais.compliant.domain.model.NewCompliantRequest
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class AddCompliantUseCase(
    private val repository: BaseRepository<Compliant>
) {
    operator fun invoke(request: NewCompliantRequest) = request.run {
        Compliant(
            -1,
            local,
            description,
            Date.from(Instant.now()),
            files.map(::Base64),
            "",
            emptyList(),
            false,
            Date.from(Instant.now())
        )
    }.run(repository::insert)
}