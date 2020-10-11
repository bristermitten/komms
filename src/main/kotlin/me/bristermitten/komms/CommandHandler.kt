package me.bristermitten.komms

import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import me.bristermitten.komms.sender.Sender
import java.util.*

/**
 * @author AlexL
 */
class CommandHandler {
    val commands = CommandMap()


    fun handle(sender: Sender<*>, input: String) {
        val parts = input.split(" ")
        val name = parts.firstOrNull() ?: return

        val matchingCommands = commands[name.toLowerCase()] ?: return sender.reply("Unknown command $name")
        val args = parts.drop(1)

        for (command in matchingCommands) {
            val parsed = tryParse(args.toList(), command)
            val successes = parsed.filterIsInstance<Success<*>>()
            if (successes.size != parsed.size) {
                continue
            }
            command.execute(successes.map { it.value })
            return
        }

        sender.reply("Illegal arguments $args")
    }

    private fun tryParse(args: List<String>, command: Command): List<ParseResult<*>> {
        val arguments = command.arguments
        val argStack = ArrayDeque(args)

        return arguments.map {
            it.parser.parse(argStack)
        }
    }
}
