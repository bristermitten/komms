package me.bristermitten.komms.argument

import kotlin.reflect.KClass

data class ArgumentSnapshot<T : Any>(
    val name: String,
    val type: KClass<T>
)
