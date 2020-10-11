package me.bristermitten.komms.command

import me.bristermitten.komms.argument.Argument

internal data class RealizedCommand(
    override val name: String,
    override val arguments: List<Argument<*>>,
    private val body: (arguments: List<Any>) -> Unit
) : RegisteredCommand {

    override fun execute(arguments: List<Any>) {
        body(arguments)
    }
}
