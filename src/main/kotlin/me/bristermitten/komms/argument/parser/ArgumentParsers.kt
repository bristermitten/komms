package me.bristermitten.komms.argument.parser

import kotlin.reflect.KClass

class ArgumentParsers {
    private val parsers = mutableMapOf<KClass<*>, ArgumentParser<*>>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> resolveParser(type: KClass<T>): ArgumentParser<T>? {
        val found = parsers[type]
        if (found != null) {
            return found as ArgumentParser<T>?
        }
        if (type == Any::class) { //prevent infinite recursion
            return found
        }

        val firstSuperType =
            type.supertypes.asSequence().mapNotNull { it.classifier as? KClass<*> }.firstOrNull() ?: Any::class
        val superParser = resolveParser(firstSuperType)
        if (superParser != null) {
            parsers[type] = superParser //Cache it to avoid unnecessary recursion
        }

        return superParser as ArgumentParser<T>?
    }

    inline fun <reified T : Any> resolveParser() = resolveParser(T::class)

    fun <T : Any> registerParser(type: KClass<T>, parser: ArgumentParser<T>) {
        parsers[type] = parser
    }

    inline fun <reified T : Any> registerParser(parser: ArgumentParser<T>) {
        return registerParser(T::class, parser)
    }
}
