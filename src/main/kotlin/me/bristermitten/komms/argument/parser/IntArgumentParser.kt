package me.bristermitten.komms.argument.parser

import java.util.*

/**
 * @author AlexL
 */
object IntArgumentParser : ArgumentParser<Int> {
    override fun parse(arguments: Deque<String>): ParseResult<Int> {
        val toInt = arguments.pop().toIntOrNull()
        return toInt?.let(::Success) ?: Failure("$toInt is not an integer.")
    }
}
