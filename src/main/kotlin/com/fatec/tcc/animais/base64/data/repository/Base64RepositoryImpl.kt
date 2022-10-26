package com.fatec.tcc.animais.base64.data.repository

import com.fatec.tcc.animais.base64.data.entity.Base64EntityRepository
import com.fatec.tcc.animais.base64.domain.repository.Base64Repository
import org.springframework.stereotype.Repository

@Repository
internal class Base64RepositoryImpl(
    private val base64EntityRepository: Base64EntityRepository
) : Base64Repository {
    override fun delete(id: Long) = base64EntityRepository.deleteById(id)
}