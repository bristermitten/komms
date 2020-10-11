@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.komms

import me.bristermitten.komms.argument.ArgumentSnapshot
import me.bristermitten.komms.command.Command
import me.bristermitten.komms.command.command
import me.bristermitten.komms.sender.PlayerCommandSender
import me.bristermitten.komms.sender.Sender
import me.bristermitten.komms.sender.SpigotCommandSender

/**
 * @author AlexL
 */

fun <T : Any> playerCommand(
    name: String,
    arg1: ArgumentSnapshot<T>,
    body: PlayerCommandSender.(T) -> Unit,
): Command<PlayerCommandSender> {
    return command(name, arg1, body)
}

fun <T : Any> consoleCommand(
    name: String,
    arg1: ArgumentSnapshot<T>,
    body: SpigotCommandSender.(T) -> Unit,
): Command<SpigotCommandSender> {
    return command(name, arg1, body)
}

