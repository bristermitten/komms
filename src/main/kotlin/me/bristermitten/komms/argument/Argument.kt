package me.bristermitten.komms.argument

import me.bristermitten.komms.argument.parser.ArgumentParser
import kotlin.reflect.KClass

/**
 * @author AlexL
 */
interface Argument<T : Any> {
    val type: KClass<T>
    val name: String

    val parser: ArgumentParser<T>
}
