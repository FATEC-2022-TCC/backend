package com.fatec.tcc.animais.base

data class SearchProjectionAndStatusesResponse<T>(
    val page: Page<T>,
    val statuses: List<StateDescription>
)