package com.fatec.tcc.animais.user.data.entity

import com.fatec.tcc.animais.animal.data.entity.AnimalEntity
import com.fatec.tcc.animais.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @Column(unique = true)
    val username: String,
    val password: String,
    val email: String,
    val authority: String,
    val isActive: Boolean,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    val animals: List<AnimalEntity>
) : BaseEntity()