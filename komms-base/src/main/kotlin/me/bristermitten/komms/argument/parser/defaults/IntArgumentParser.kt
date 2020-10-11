package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.Failure
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import java.util.*

/**
 * @author AlexL
 */
internal object IntArgumentParser : ArgumentParser<Int> {
    override fun parse(arguments: Deque<String>): ParseResult<Int> {
        val toInt = arguments.pop().toIntOrNull()
        return toInt?.let(::Success) ?: Failure("$toInt is not an integer.")
    }
}
