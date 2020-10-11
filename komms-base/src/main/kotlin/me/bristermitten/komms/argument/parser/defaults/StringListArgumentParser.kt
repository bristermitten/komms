package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import java.util.*

/**
 * @author AlexL
 */
internal object StringListArgumentParser : ArgumentParser<List<String>> {
    override fun parse(arguments: Deque<String>): ParseResult<List<String>> {
        return Success(arguments.toList()) //well this is easy...
    }
}

