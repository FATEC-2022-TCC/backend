package com.fatec.tcc.animais.base

interface SearchableRepository<Projection, Data> {
    fun search(data: Data, page: Int, size: Int): Page<Projection>
}