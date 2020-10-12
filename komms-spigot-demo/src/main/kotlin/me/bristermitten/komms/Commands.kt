package me.bristermitten.komms

import me.bristermitten.komms.command.*
import me.bristermitten.komms.sender.DummySender.sender
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

val broadcastCommand = consoleCommand("broadcast", vararg("message")) { message ->
    Bukkit.broadcastMessage(message.joinToString(" ").color())
}

val locations = mutableListOf<Location>()

val shopsCommand = command("locations") {
    root aliasOf "list"

    subcommand("all") aliasOf "list"

    subcommand("list", arg<Int>("limit").optional()) { limit ->
        reply(locations.take(limit ?: locations.size).joinToString("\n"))
    }

    subcommand("create", sender<Player>()) {
        locations += sender.location
    }
}
