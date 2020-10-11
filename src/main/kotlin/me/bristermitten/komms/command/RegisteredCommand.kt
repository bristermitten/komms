package me.bristermitten.komms.command

import me.bristermitten.komms.argument.Argument
import me.bristermitten.komms.sender.Sender
import kotlin.reflect.KClass

/**
 * @author AlexL
 */
interface RegisteredCommand<T: Sender<*>> {
    val name: String

    val senderType: KClass<T>

    val arguments: List<Argument<*>>

    fun execute(sender: T, arguments: List<Any>)
}
