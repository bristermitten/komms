package me.bristermitten.komms.argument.parser

import java.util.*

/**
 * @author AlexL
 */
object IntArgumentParser : ArgumentParser<Int> {
    override fun parse(arguments: Deque<String>): Int {
        return arguments.pop().toInt()
    }
}
