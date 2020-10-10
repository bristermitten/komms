package me.bristermitten.komms

import java.util.*

/**
 * @author AlexL
 */
class CommandHandler {
    val commands = CommandMap()


    fun handle(input: String) {
        val parts = input.split(" ")
        val name = parts.firstOrNull() ?: return

        val matchingCommands = commands[name.toLowerCase()] ?: return println("Unknown command $name")
        val args = parts.drop(1)
        matchingCommands.forEach {
            val parsed = tryParse(args.toList(), it)
            if(parsed != null) {
                it.execute(parsed)
                return
            }
        }
    }

    private fun tryParse(args: List<String>, command: Command): List<Any>? {
        val arguments = command.arguments
        val argStack = ArrayDeque(args)

        val argValues = mutableListOf<Any>()
        arguments.forEach {
            val parsed = runCatching {  it.parser.parse(argStack) }.getOrNull()
                ?: //parsing failed
                return null

            argValues += parsed
        }
        return argValues
    }
}
