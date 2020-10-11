package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.Failure
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import java.util.*

/**
 * @author AlexL
 */
internal object DoubleArgumentParser : ArgumentParser<Double> {
    override fun parse(arguments: Deque<String>): ParseResult<Double> {
        val toInt = arguments.pop().toDoubleOrNull()
        return toInt?.let(::Success) ?: Failure("$toInt is not a double.")
    }
}
