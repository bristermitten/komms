package me.bristermitten.komms

import me.bristermitten.komms.argument.parser.spigot.PlayerArgumentParser
import org.bukkit.plugin.Plugin

fun spigotCommandHandler(plugin: Plugin): CommandHandler {
    val handler = CommandHandler()
    val platform = SpigotPlatform(handler, plugin)
    handler.platform = platform

    handler.parsers.registerParser(PlayerArgumentParser)

    return handler
}
