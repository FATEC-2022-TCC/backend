package com.fatec.tcc.animais.user.data.entity

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val username: String,
    val password: String,
    val email: String,
    val authorities: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "animal_id")
    val animals: List<AnimalEntity>
)