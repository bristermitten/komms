package me.bristermitten.komms.platform

import me.bristermitten.komms.command.Command
import me.bristermitten.komms.sender.Sender

interface Platform {
    fun registerPlatformCommand(command: Command<*>)
}
