package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.Failure
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import java.util.*

/**
 * @author AlexL
 */
internal object FloatArgumentParser : ArgumentParser<Float> {

    override fun parse(arguments: Deque<String>): ParseResult<Float> {
        val toInt = arguments.pop().toFloatOrNull()
        return toInt?.let(::Success) ?: Failure("$toInt is not a float.")
    }
}
