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
    val name: String,
    @Lob
    val description: String,
    val gender: String,
    val size: String,
    val age: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    val category: CategoryEntity,
    @Lob
    val picture: String,
) : BaseEntity()