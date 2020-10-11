package me.bristermitten.komms

import me.bristermitten.komms.command.Command
import me.bristermitten.komms.platform.Platform
import me.bristermitten.komms.sender.SpigotCommandSender
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin
import org.bukkit.command.Command as BukkitCommand

class SpigotPlatform(val handler: CommandHandler, private val plugin: Plugin) : Platform {
    override fun registerPlatformCommand(command: Command<*>) {
        val result = commandMap.register(plugin.name, command.toBukkitCommand())
        println("Registered command ${command.name} with result $result!")
    }

    private fun Command<*>.toBukkitCommand(): BukkitCommand {
        return object : BukkitCommand(name) {
            override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
                handler.handle(
                    SpigotCommandSender(sender),
                    name + " " + args.joinToString(separator = " ")
                )
                return true
            }

        }
    }
}
