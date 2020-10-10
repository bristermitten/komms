package me.bristermitten.komms.argument.parser

import java.util.*

/**
 * @author AlexL
 */
interface ArgumentParser<T> {
    fun parse(arguments: Deque<String>) : T
}
