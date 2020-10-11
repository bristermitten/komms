package me.bristermitten.komms

import me.bristermitten.komms.command.arg
import org.bukkit.Bukkit

val broadcastCommand = consoleCommand("broadcast", arg("message")) { message ->
    Bukkit.broadcastMessage(message.color())
}
