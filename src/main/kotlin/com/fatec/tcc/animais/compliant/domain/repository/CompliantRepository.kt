package com.fatec.tcc.animais.compliant.domain.repository

import com.fatec.tcc.animais.compliant.domain.model.Compliant
import java.util.*

interface CompliantRepository {
    fun insert(compliant: Compliant): Compliant
    fun until(date: Date): List<Compliant>
    fun all(): List<Compliant>
    fun delete(id: Long)
    fun get(id: Long): Compliant?
    fun update(compliant: Compliant): Compliant
}