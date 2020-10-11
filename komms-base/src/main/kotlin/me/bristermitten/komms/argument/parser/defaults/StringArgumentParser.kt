package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import java.util.*

/**
 * @author AlexL
 */
internal object StringArgumentParser : ArgumentParser<String> {
    override fun parse(arguments: Deque<String>): ParseResult<String> {
        return Success(arguments.pop())
    }
}
