package me.bristermitten.komms

import me.bristermitten.komms.command.Command
import me.bristermitten.komms.platform.Platform
import me.bristermitten.komms.sender.PlayerCommandSender
import me.bristermitten.komms.sender.SpigotCommandSender
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.command.Command as BukkitCommand

class SpigotPlatform(val handler: CommandHandler, private val plugin: Plugin) : Platform {
    override fun registerPlatformCommand(command: Command<*>) {
        commandMap.register(plugin.name, command.toBukkitCommand())
    }

    private fun Command<*>.toBukkitCommand(): BukkitCommand {
        return object : BukkitCommand(name) {
            override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
                val senderWrapper = when (sender) {
                    is Player -> PlayerCommandSender(sender)
                    else -> SpigotCommandSender(sender)
                }
                handler.handle(
                    senderWrapper,
                    name + " " + args.joinToString(separator = " ")
                )
                return true
            }

        }
    }
}
