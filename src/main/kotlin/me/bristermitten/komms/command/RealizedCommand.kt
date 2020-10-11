package me.bristermitten.komms.command

import me.bristermitten.komms.argument.Argument
import me.bristermitten.komms.sender.Sender
import kotlin.reflect.KClass

internal data class RealizedCommand<T : Sender<*>>(
    override val name: String,
    override val senderType: KClass<T>,
    override val arguments: List<Argument<*>>,
    private val body: T.(arguments: List<Any>) -> Unit,
) : RegisteredCommand<T> {

    override fun execute(sender: T, arguments: List<Any>) {
        sender.body(arguments)
    }
}
