package com.fatec.tcc.animais.animal.domain.model

import java.util.*

class UpdateAnimalRequest(
    val name: String,
    val description: String,
    val type: String,
    val birth: Date
)