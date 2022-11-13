package com.fatec.tcc.animais.category.data.entity

import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import javax.persistence.*

@Entity
@Table(name = "categories")
class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val name: String,
    @Lob
    val description: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "category_image_id")
    val images: List<Base64Entity>
)