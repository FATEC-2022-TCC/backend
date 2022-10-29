package com.fatec.tcc.animais.base

interface SearchableRepository<T> {
    fun search(data: String, page: Int, size: Int): Page<T>
}