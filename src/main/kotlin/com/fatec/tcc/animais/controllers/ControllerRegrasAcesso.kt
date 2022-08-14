package com.fatec.tcc.animais.controllers

import com.fatec.tcc.animais.regrasAcesso.RegrasAcessoEntity
import com.fatec.tcc.animais.regrasAcesso.RegrasAcessoRepository
import com.fatec.tcc.animais.regrasAcesso.RegrasAcessoRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalStateException

@RestController
@RequestMapping("/registrarAcesso")
class ControllerRegrasAcesso(
    private val regrasAcessoRepository: RegrasAcessoRepository
) {
    @PostMapping("/novoAcesso")
    fun postAcesso(@RequestBody regrasAcessoRequest: RegrasAcessoRequest): RegrasAcessoEntity {
        if (regrasAcessoRequest.id != -1L) {
            throw IllegalStateException("Id must be -1")
        }
        val entity = regrasAcessoRequest.run {
            RegrasAcessoEntity(id, idUsuario, typeAcess)
        }
        return regrasAcessoRepository.save(entity)
    }
}