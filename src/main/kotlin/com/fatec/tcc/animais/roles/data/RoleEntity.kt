package com.fatec.tcc.animais.roles.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "roles")
class RoleEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val number: Int
)