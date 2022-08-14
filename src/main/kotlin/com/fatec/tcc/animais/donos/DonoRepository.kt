package com.fatec.tcc.animais.donos

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonoRepository : JpaRepository<DonoEntity, Long>