package me.bristermitten.komms.argument

import me.bristermitten.komms.argument.parser.ArgumentParser
import kotlin.reflect.KClass

/**
 * @author AlexL
 */
interface Argument<T : Any> {
    val name: String

    val type: KClass<T>

    val parser: ArgumentParser<T>
}
