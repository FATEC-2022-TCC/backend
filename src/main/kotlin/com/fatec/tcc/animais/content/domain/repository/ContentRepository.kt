package com.fatec.tcc.animais.content.domain.repository

import com.fatec.tcc.animais.content.domain.model.Content

interface ContentRepository {
    fun insert(content: Content): Content
}