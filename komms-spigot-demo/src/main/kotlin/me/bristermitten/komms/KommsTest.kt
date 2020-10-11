package me.bristermitten.komms

import org.bukkit.plugin.java.JavaPlugin

class KommsTest : JavaPlugin() {

    override fun onEnable() {
        val manager = spigotCommandHandler(this)
        manager.registerCommand(broadcastCommand)
    }
}
