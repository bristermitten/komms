package me.bristermitten.komms.argument.parser

import java.util.*

/**
 * @author AlexL
 */
object StringArgumentParser : ArgumentParser<String> {
    override fun parse(arguments: Deque<String>): ParseResult<String> {
        return Success(arguments.pop())
    }
}
