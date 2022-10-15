package com.fatec.tcc.animais

import com.fatec.tcc.animais.services.file.PublicFileService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class SpringApplicationRunner(
    private val publicFileService: PublicFileService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        publicFileService.run(args)
    }
}

interface Runner {
    fun run(args: ApplicationArguments)
}