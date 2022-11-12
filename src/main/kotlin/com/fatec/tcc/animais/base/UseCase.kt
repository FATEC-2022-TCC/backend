package com.fatec.tcc.animais.base

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

/**
 * Indicates that an annotated class is a "UseCase", originally defined by
 * "No one care" as "single method class, which denotes a business logical action"
 */

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Component
annotation class UseCase(
    @get:AliasFor(annotation = Component::class)
    val value: String = ""
)