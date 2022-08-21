package com.fatec.tcc.animais.user.data

import com.fatec.tcc.animais.animal.data.AnimalEntity
import com.fatec.tcc.animais.roles.data.RoleEntity
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val email: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    val roles: List<RoleEntity>,
    @OneToMany(
    fetch = FetchType.LAZY,
    cascade = [CascadeType.ALL],
    orphanRemoval = true
    )
    @JoinColumn(name = "animal_id")
    val animals: List<AnimalEntity>

)