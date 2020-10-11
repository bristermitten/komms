package me.bristermitten.komms.sender

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

open class SpigotCommandSender(override val sender: CommandSender) : Sender<CommandSender> {
    override fun reply(message: String) {
        sender.sendMessage(message)
    }
}

data class PlayerCommandSender(override val sender: Player) : SpigotCommandSender(sender)
