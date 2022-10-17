package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.Content
import java.util.*

interface ContentRepository {
    fun insert(content: Content): Content
    fun until(date: Date): List<Content>
    fun all(): List<Content>
}