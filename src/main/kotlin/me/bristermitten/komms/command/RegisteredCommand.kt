package me.bristermitten.komms.command

import me.bristermitten.komms.argument.Argument
import me.bristermitten.komms.sender.Sender

/**
 * @author AlexL
 */
interface RegisteredCommand {
    val name: String

    val arguments: List<Argument<*>>

    fun execute(arguments: List<Any>)
}
