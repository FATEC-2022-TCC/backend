package com.fatec.tcc.animais.base

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
    @CreatedDate
    @Column(updatable = false)
    var created: Instant = Instant.now(),
    @LastModifiedDate
    var updated: Instant = Instant.now(),
    @CreatedBy
    @Column(updatable = false)
    var createdBy: String = "",
    @LastModifiedBy
    var updatedBy: String = "",
)