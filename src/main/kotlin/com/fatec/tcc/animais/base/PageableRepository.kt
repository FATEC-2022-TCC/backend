package com.fatec.tcc.animais.base

interface PageableRepository<T> {
    fun all(page: Int, size: Int): Page<T>
}