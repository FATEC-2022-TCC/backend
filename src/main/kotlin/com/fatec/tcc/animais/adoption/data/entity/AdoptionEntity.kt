package com.fatec.tcc.animais.adoption.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import com.fatec.tcc.animais.category.data.entity.CategoryEntity
import com.fatec.tcc.animais.status.data.entity.StatusEntity
import javax.persistence.*

@Entity
@Table(name = "adoptions")
class AdoptionEntity(
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
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val images: List<Base64Entity>,
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val statuses: List<StatusEntity>,
    val currentStatusCode: Int,
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val requests: List<AdoptionRequestEntity>
) : BaseEntity()