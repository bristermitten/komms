package me.bristermitten.komms

import me.bristermitten.komms.command.arg
import me.bristermitten.komms.command.vararg
import org.bukkit.Bukkit
import org.bukkit.entity.Player

val broadcastCommand = consoleCommand("broadcast", vararg("message")) { message ->
    Bukkit.broadcastMessage(message.joinToString(" ").color())
}

val messageCommand = playerCommand(
    "message",
    arg<Player>("target"),
    vararg("message")
) { target, message ->
    target.sendMessage("&6${sender.name} &7-> &6you: &7${message.joinToString(" ")}".color())
}
