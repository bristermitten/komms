package me.bristermitten.komms.argument.parser

import java.util.*

/**
 * @author AlexL
 */
interface ArgumentParser<T : Any> {
    fun parse(arguments: Deque<String>) : ParseResult<T>
}
