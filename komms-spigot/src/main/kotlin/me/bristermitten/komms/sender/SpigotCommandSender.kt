package me.bristermitten.komms.sender

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

open class SpigotCommandSender(override val value: CommandSender) : Sender<CommandSender> {
    override fun reply(message: String) {
        value.sendMessage(message)
    }
}

data class PlayerCommandSender(override val value: Player) : SpigotCommandSender(value)
