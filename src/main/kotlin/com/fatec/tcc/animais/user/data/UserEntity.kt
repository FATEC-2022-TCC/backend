package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.roles.data.RoleEntity
import javax.persistence.*

@Entity(name = "users")
class UserEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val email: String,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val roles: List<RoleEntity>
)