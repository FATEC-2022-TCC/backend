package com.fatec.tcc.animais.base

interface SearchableRepository<T, D> {
    fun search(data: D, page: Int, size: Int): Page<T>
}