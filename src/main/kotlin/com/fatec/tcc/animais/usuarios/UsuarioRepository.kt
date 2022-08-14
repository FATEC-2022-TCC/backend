package com.fatec.tcc.animais.usuarios

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<UsuarioEntity, Long>