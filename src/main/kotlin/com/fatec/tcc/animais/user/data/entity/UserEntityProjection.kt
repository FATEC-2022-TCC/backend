package com.fatec.tcc.animais.user.data.entity

import org.springframework.beans.factory.annotation.Value

interface UserEntityProjection {
    val id: Long
    val name: String
    val username: String
    //it's needed because of projection poor implementation isn't recognizing byte as boolean on query
    @get:Value("#{target.isActive}")
    val isActive: Boolean
    @get:Value("#{target.isValidated}")
    val isValidated: Boolean
}