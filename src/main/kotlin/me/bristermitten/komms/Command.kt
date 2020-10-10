package me.bristermitten.komms

import me.bristermitten.komms.argument.Argument
import me.bristermitten.komms.sender.Sender

/**
 * @author AlexL
 */
interface Command {
    val name: String

    val senderType: Sender<*>

    val arguments: List<Argument<*>>

    fun execute(arguments: List<Any>)
}
