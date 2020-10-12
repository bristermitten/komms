package me.bristermitten.komms.argument

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType

data class ArgumentSnapshot<T : Any?>(
    val name: String,
    val klass: KClass<*>?,
    //we can't use KClass<T> here since T is nullable, but if [klass] is not null, it will always be of type T!!
    val type: KType
) {
    constructor(name: String, klass: KClass<*>) : this(name, klass, klass.createType())
}
