package me.bristermitten.komms.platform

import me.bristermitten.komms.command.Command

object BasePlatform : Platform {
    override fun registerPlatformCommand(command: Command<*>) {
        //No-op
    }
}
