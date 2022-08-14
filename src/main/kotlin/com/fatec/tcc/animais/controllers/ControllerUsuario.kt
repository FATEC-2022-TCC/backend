package com.fatec.tcc.animais.controllers

import com.fatec.tcc.animais.usuarios.UsuarioEntity
import com.fatec.tcc.animais.usuarios.UsuarioRepository
import com.fatec.tcc.animais.usuarios.UsuarioRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalStateException

@RestController
@RequestMapping("/registrar")
class ControllerUsuario(
    private val usuarioRepository: UsuarioRepository
) {
    @PostMapping("/novousuario")
    fun postUsuario(@RequestBody usuarioRequest: UsuarioRequest): UsuarioEntity {
        if (usuarioRequest.id != -1L) {
            throw IllegalStateException("Id must be -1")
        }
        val entity = usuarioRequest.run {
            UsuarioEntity(id, username, password, email,dataNasc,age)
        }
        return usuarioRepository.save(entity)
    }
}