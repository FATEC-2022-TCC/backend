package com.fatec.tcc.animais.controllers

import com.fatec.tcc.animais.donos.DonoEntity
import com.fatec.tcc.animais.donos.DonoRepository
import com.fatec.tcc.animais.donos.DonoRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalStateException

@RestController
@RequestMapping("/registrarDono")
class ControllerDono(
    private val donoRepository: DonoRepository
) {
    @PostMapping("/novoDonoAnimal")
    fun postDonoAnimal(@RequestBody donoRequest: DonoRequest): DonoEntity {
        if (donoRequest.id != -1L) {
            throw IllegalStateException("Id must be -1")
        }
        val entity = donoRequest.run {
            DonoEntity(id, idUsuario, idAnimal)
        }
        return donoRepository.save(entity)
    }
}