package com.fatec.tcc.animais.base

import org.springframework.data.domain.Page

data class Page<T>(
    val pages: Int,
    val items: List<T>
)

inline fun <A, B> Page<A>.toPage(mapper: (A) -> B) = Page(
    totalPages,
    content.map(mapper)
)