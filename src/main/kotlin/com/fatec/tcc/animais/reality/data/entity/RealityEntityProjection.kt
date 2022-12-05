package com.fatec.tcc.animais.reality.data.entity

import org.springframework.beans.factory.annotation.Value

interface RealityEntityProjection {
    val id: Long
    val title: String
    val background: String
    @get:Value("#{target.isVisible}")
    val isVisible: Boolean
}