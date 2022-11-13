package com.fatec.tcc.animais.base

data class DataAndAllowedStatus<T>(
    val data: T,
    val allowedStatus: List<StateDescription>
)