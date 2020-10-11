package me.bristermitten.komms.argument

import me.bristermitten.komms.argument.parser.ArgumentParser
import kotlin.reflect.KClass

data class RealizedArgument<T : Any>(
    override val name: String,
    override val type: KClass<T>,
    override val parser: ArgumentParser<T>
) : Argument<T>
