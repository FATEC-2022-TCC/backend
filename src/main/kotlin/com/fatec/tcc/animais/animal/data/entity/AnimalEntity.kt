package com.fatec.tcc.animais.animal.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.category.data.entity.CategoryEntity
import javax.persistence.*

@Entity
@Table(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val picture: String,
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    val category: CategoryEntity,
    val gender: String,
    val age: String,
    val size: String,
    @Lob
    val about: String
) : BaseEntity()